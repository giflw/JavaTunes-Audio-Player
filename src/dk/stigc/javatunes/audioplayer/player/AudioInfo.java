package dk.stigc.javatunes.audioplayer.player;

import dk.stigc.javatunes.audioplayer.other.Codec;

public class AudioInfo
{
	public int sourceHashCode;
	public int channels, sampleRate, bitsPerSample;
	public int kbps, kbpsVar;
	public int lengthInSeconds;
	public long positionInMs;
	public long lengthInBytes;
	public int icyMetaInt;
	public String icyName, icyGenre, icyStreamTitle;
	public Codec codec;
	public String newLocation;
	
	@Override
	public String toString()
	{
		String s = "lengthInSeconds=" + lengthInSeconds;
		s += ", channels=" + channels;
		s += ", sampleRate=" + sampleRate;
		s += ", bitsPerSample=" + bitsPerSample;
		s += ", kbps=" + kbps;
		s += ", positionInMs=" + positionInMs;
		if (kbpsVar > 0)
			s += ", kbpsVariable=" + kbpsVar;
		s += ", lengthInBytes=" + lengthInBytes;
		s += ", codec=" + codec;
		if (newLocation != null)
			s += ", newLocation=" + newLocation;		
		if (icyName != null)
			s += ", icyName=" + icyName;
		if (icyGenre != null)
			s += ", icyGenre=" + icyGenre;
		if (icyStreamTitle != null)
			s += ", icyNowPlaying=" + icyStreamTitle;
		return s;
	}
}
 