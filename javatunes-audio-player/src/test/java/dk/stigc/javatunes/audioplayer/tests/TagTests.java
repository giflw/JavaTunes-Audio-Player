package dk.stigc.javatunes.audioplayer.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import org.junit.Ignore;
import org.junit.Test;

import dk.stigc.javatunes.audioplayer.other.Log;
import dk.stigc.javatunes.audioplayer.other.Track;
import dk.stigc.javatunes.audioplayer.tagreader.TagReaderManager;

public class TagTests
{
	String root = "C:\\data\\Projekter\\Eclipse.workspace\\JavaTunes\\other\\Test audio files\\";
	
	public String resourceToFilePath(String resource) throws URISyntaxException {
		return new File(this.getClass().getResource(resource).toURI()).getAbsolutePath();
	}

	@Test
	@Ignore
	public void id3v22Tags() throws Exception
	{
		File file = new File(root + "MP3\\01 Steady As She Goes.id3v2.2.mp3");
		Track track = new TagReaderManager().read(file);
		assertEquals("Track [artists=The Raconteurs, album=Broken Boy Soldiers"
				+ ", title=Steady As She Goes, genres=Rock, year=2006"
				+ ", trackNumber=01, codec=mp3]"
				, track.toString());		

	}
	@Test
	@Ignore
	public void quicktimeAacTags() throws FileNotFoundException
	{
		String path = root + "AAC\\03 Down The Nightclub.m4a";
		Track track = new TagReaderManager().read(new File(path));
		assertEquals("Track [artists=Tower Of Power"
				+ ", album=The Very Best of Tower Of Power The Warner Years"
				+ ", title=Down The Nightclub, genres=Funk"
				+ ", trackNumber=03, codec=aac]"
				, track.toString());
	}
	
	@Test
	@Ignore
	public void oggOpusComments() throws Exception
	{
		File file = new File(root + "opus\\04 - Within.opus");
		Track track = new TagReaderManager().read(file);
		assertEquals("Track [artists=Daft Punk, album=Random Access Memories, title=Within"
				+ ", genres=Electronic, year=2013, trackNumber=04, codec=opus]"
				, track.toString());
	}	
	
	@Test
	@Ignore
	public void oggVorbisComments() throws Exception
	{
		File file = new File(resourceToFilePath("/test.ogg"));
		Track track = new TagReaderManager().read(file);
		assertEquals("Track [artists=Abba, album=Voulez-Vous, title=Chiquitta"
				+ ", genres=Pop, year=1979, trackNumber=11, codec=vorbis"
				+ ", replaygain=-3.94, replaygainAlbumMode=-8.48]"
				, track.toString());
	}	
	
	@Test
	public void trackNumberTesting() throws Exception
	{
		File file = new File(resourceToFilePath("/test.mp3"));
		Track track = new TagReaderManager().read(file);
		assertEquals(5, track.trackNumber);
	}	
	
	@Test
	public void trackNumberTestign2() throws Exception
	{
		File file = new File(resourceToFilePath("/test.aac"));
		Track track = new TagReaderManager().read(file);
		Log.write(""+track.discNumber);
	}	
}
