package edu.handong.isel.jgit.command;

import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

import edu.handong.isel.jgit.jgitOpen;

public class git_log {

	public static void main(String[] args) {

		String URI = null; // local git repository
		URI = ".";
		// URI = "/Users/imseongbin/documents/Java/jgit-example";

		try {
			jgitOpen open = new jgitOpen(URI);
			Git git = open.getGit();

			Iterable<RevCommit> logs = git.log().call();

			int count = 0;
			System.out.println("Commit_Hash *** Short_Message *** Date *** AuthorIdent ***\n");
			for (RevCommit rev : logs) {
				System.out.print(rev.getId().getName() + " *** ");
				System.out.print(rev.getShortMessage() + " *** ");
				System.out.print(rev.getCommitTime() + " *** ");
				System.out.println(rev.getAuthorIdent().getName());
				count++;
			}
			System.out.println("\nthe number of commit: " + count);

		} catch (IOException | GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
