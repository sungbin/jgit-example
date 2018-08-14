package edu.handong.isel.jgit;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;

public class jgitOpen {
	private Git git;

	public Git getGit() {
		return git;
	}

	/**
	 * help to open local git repository. return Git.
	 * 
	 * @param localURI
	 * @throws IOException
	 */
	public jgitOpen(String localURI) throws IOException {
		git = Git.open(new File(localURI));
	}
}
