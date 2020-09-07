package com.badlogic.gdx.assets.loaders.resolvers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public class ClasspathFileHandleResolver implements FileHandleResolver {
  public FileHandle resolve(String paramString) { return Gdx.files.classpath(paramString); }
}


/* Location:              /home/r00tus3r/ctfs/2020/alles/re/prehistoric-mario-dex2jar.jar!/com/badlogic/gdx/assets/loaders/resolvers/ClasspathFileHandleResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.6
 */