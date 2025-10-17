from pytube import YouTube

url = "https://www.youtube.com/watch?v=W9tVrYcNa50"
yt = YouTube(url)
video = yt.streams.get_highest_resolution()
video.download("videos/")
print("Descarga completada ✅")
