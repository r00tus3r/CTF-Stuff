package com.badlogic.gdx.assets.loaders.resolvers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public class InternalFileHandleResolver implements FileHandleResolver {
  public FileHandle resolve(String paramString) { return Gdx.files.internal(paramString); }
}


/* Location:              /home/r00tus3r/ctfs/2020/alles/re/prehistoric-mario-dex2jar.jar!/com/badlogic/gdx/assets/loaders/resolvers/InternalFileHandleResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.6
 */