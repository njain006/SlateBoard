//package slateboard;
//
//
//import javax.media.*;
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.net.MalformedURLException;
//
//public class SimpleAudioPlayer
//{
//private Player audioPlayer = null;
//
//public SimpleAudioPlayer(URL url) throws IOException, NoPlayerException, CannotRealizeException
//    {
//        audioPlayer = Manager.createRealizedPlayer(url);
//    }
//
//public SimpleAudioPlayer(File file) throws IOException, NoPlayerException, CannotRealizeException
//    {
//        this(file.toURL());
//    }
//
//public void play()
//    {
//        audioPlayer.start();
//    }
//public void stop()
//    {
//        audioPlayer.stop();
//        audioPlayer.close();
//    }
//public static void main(String args[])throws Exception
//    {
//        File audioFile = new File("Akcent.mp3");
//        SimpleAudioPlayer player = new SimpleAudioPlayer(audioFile);
//        player.play();
//        //player.stop();
//    }
//
//}