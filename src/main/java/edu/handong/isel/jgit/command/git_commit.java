package edu.handong.isel.jgit.command;

import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import edu.handong.isel.jgit.jgitOpen;

public class git_commit {

	public static void main() {

		String URI = null; // local git repository
		URI = ".";
		// URI = "/Users/imseongbin/documents/Java/jgit-example";

		jgitOpen open;
		try {
			open = new jgitOpen(URI);

			Git git = open.getGit();

			boolean Option_a = true; // git commit <-a>

			String filePattern = ".";
			git.add().addFilepattern(filePattern).call(); // if file match 'filePattern', add it to index/

			git.commit().setAll(Option_a).setMessage("Add git_commit\nIt is same to git commit <-a> <-m Message>").call();

		} catch (IOException | GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}