package edu.handong.isel.jgit;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;

public class jgitOpen {
	private Git git;
	private Repository repository;

	public Git getGit() {
		return git;
	}

	public Repository getRepository() {
		return repository;
	}

	public jgitOpen(String localURI) throws IOException {
		Git git = Git.open(new File(localURI));
		Repository repository = git.getRepository();
	}
}
