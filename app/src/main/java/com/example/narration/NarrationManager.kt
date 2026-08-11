package com.example.narration

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class NarrationManager(context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)
    
    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady.asStateFlow()

    private val _speechRate = MutableStateFlow(1.0f)
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    private val _statusMessage = MutableStateFlow("Inicializando motor de voz PT-BR...")
    val statusMessage: StateFlow<String> = _statusMessage.asStateFlow()

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale("pt", "BR"))
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Fallback to default PT locale if PT-BR specific fails
                val fallbackResult = tts?.setLanguage(Locale("pt"))
                if (fallbackResult == TextToSpeech.LANG_MISSING_DATA || fallbackResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                    _statusMessage.value = "Idioma Português não instalado no TTS do dispositivo."
                    Log.e("NarrationManager", "Language PT not supported")
                } else {
                    _isReady.value = true
                    _statusMessage.value = "Narração PT pronta"
                }
            } else {
                _isReady.value = true
                _statusMessage.value = "Narração em Português do Brasil pronta"
            }

            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    _isSpeaking.value = true
                    _statusMessage.value = "Narrando conteúdo..."
                }

                override fun onDone(utteranceId: String?) {
                    _isSpeaking.value = false
                    _statusMessage.value = "Narração concluída"
                }

                @Deprecated("Deprecated in Java")
                override fun onError(utteranceId: String?) {
                    _isSpeaking.value = false
                    _statusMessage.value = "Erro na reprodução de voz"
                }
            })
        } else {
            _statusMessage.value = "Falha ao inicializar motor Text-To-Speech"
            Log.e("NarrationManager", "TTS initialization failed")
        }
    }

    fun speak(text: String) {
        if (!_isReady.value) {
            _statusMessage.value = "Aguardando inicialização da voz PT-BR..."
            return
        }
        stop()
        tts?.setSpeechRate(_speechRate.value)
        val params = HashMap<String, String>()
        params[TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID] = "O3BR_NARRATION_${System.currentTimeMillis()}"
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, params)
        _isSpeaking.value = true
    }

    fun pauseOrStop() {
        if (tts?.isSpeaking == true) {
            tts?.stop()
            _isSpeaking.value = false
            _statusMessage.value = "Narração pausada"
        }
    }

    fun stop() {
        tts?.stop()
        _isSpeaking.value = false
    }

    fun setSpeed(rate: Float) {
        _speechRate.value = rate
        tts?.setSpeechRate(rate)
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }
}
