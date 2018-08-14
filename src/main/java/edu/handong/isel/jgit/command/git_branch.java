package edu.handong.isel.jgit.command;

import java.io.IOException;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

import edu.handong.isel.jgit.jgitOpen;

public class git_branch {

	public static void main(String[] args) {
		String URI = null; // local git repository
		URI = ".";
		// URI = "/Users/imseongbin/documents/Java/jgit-example";

		jgitOpen open;
		try {
			open = new jgitOpen(URI);

			Git git = open.getGit();

			List<Ref> call = git.branchList().call();
			for (Ref ref : call) {
				System.out.println("Branch: " + ref.getName() + ", HEAD: " + ref.getObjectId().getName());
			}

		} catch (IOException | GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
