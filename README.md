# PVLSE: The Bridge Between Your Heart and Music
## App Summary
The basis behind the application *Pvlse* is to truly connect music listeners with their music using their heart rate. Initially designed for Twitch 
streamers, whose emotional connection to livestream viewers is quite scarce, Pvlse has the ability to track a user's heart rate and play music 
correlated to that particular heart rate. In this manner, the viewers of the Twitch stream listen to the music, and their heart beats 
change along with those of the player. Now connected through the music, the streamer and the viewers can be connected not just via Twitch but 
also by heart.
## Key Features
**Real-time heart rate detector** - By simply placing one's finger on the sensor on the back of a supporting device, Pvlse can detect their 
heart rate.

**Play song based on bpm** - Using the heart rate from the detector, Pvlse is able to choose a song to play with beats per minute close to the heart rate
of the user.

**Video player** - A video player accompanies the music being played. This feature is implemented in the case that the user desires to 
watch the music video of the song that they are listening to.
## Internal Processes
Pressing the "Measure Heart Rate" button activates the sensor, which detects the heart rate of the user once a finger is placed on the sensor.
The bpm (beats per minute) is then saved as a variable. Then, by pressing the "Play Music" button, Pvlse accesses a bpm to song database. Based
on the bpm variable already saved, the app navigates to the correct section of the database. The HTML code from the database is scraped, 
ultimately ending in the selection of a random song/artist pair to play. Using the Youtube Video Player API along with the Youtube Data API, the
selected song can now be played within the app.
## Future of Pvlse
The first major project for the future in relation to Pvlse is the addition of other music catalogs to the potential song lists. This would
begin with the 7Digital API that provides over 14,000 songs to the app in MP3 format. Another potential opportunity would involve creating a
related Twitch Extension that would enable the streamer to directly play the songs through Twitch rather than needing to open an app, although
this would create a need for change in the heart rate detection tool. A possible way to implement this change is to measure the heart rate
through the app every once in a while, which will be connected to the Twitch Extension in use. A third project could involve a sorting by year
capability in the app, enabling the user to create a range for songs that are to be played. Furthermore, we seek to create more threads in order to handle network
processes and improve speed.
