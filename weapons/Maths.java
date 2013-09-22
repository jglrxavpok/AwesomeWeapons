package org.jglrxavpok.mods.weapons;

import java.util.Random;

public class Maths
{
	public static float dist(float startX, float startY, float startZ, float x, float y, float z)
	{
		return (float)Math.sqrt(Math.pow(Math.max(startX, x)-Math.min(startX, x), 2)+Math.pow(Math.max(startY, y)-Math.min(startY, y), 2)+Math.pow(Math.max(startZ, z)-Math.min(startZ, z), 2));
	}
}
