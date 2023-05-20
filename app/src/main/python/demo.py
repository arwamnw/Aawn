"""### Try out recongition model"""

from klaam import SpeechRecognition
def python_to_java (audio):
 model = SpeechRecognition()
 return model.transcribe('demo.wav')