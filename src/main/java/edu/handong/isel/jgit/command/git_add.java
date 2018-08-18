package edu.handong.isel.jgit.command;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import edu.handong.isel.jgit.jgitOpen;

public class git_add {
	public static void main() {

		String URI = null; // local git repository
		URI = ".";
		// URI = "/Users/imseongbin/documents/Java/jgit-example";

		jgitOpen open;
		try {
			open = new jgitOpen(URI);

			Git git = open.getGit();

			// if it is in the package "edu.handong.isel.jgit.command"
			// git add them.
			String filePattern = "edu.handong" + File.separator + "isel" + File.separator + "jgit" + File.separator
					+ "command" + File.separator;

			git.add().addFilepattern(filePattern).call(); // if file match 'filePattern', add it to index/

		} catch (IOException | GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public git_add (Git git, String filePattern) {

		try {
			git.add().addFilepattern(filePattern).call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // if file match 'filePattern', add it to index/

	}
}
