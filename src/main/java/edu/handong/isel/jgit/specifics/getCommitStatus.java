package edu.handong.isel.jgit.specifics;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

import edu.handong.isel.jgit.jgitOpen;

public class getCommitStatus {

	public static void main(String[] args) {
		String URI = null; // local git repository
		URI = ".";

		String CommitHash = "075c3fe97a4a19c9e93ddb606f877b28e1a66a17";

		jgitOpen open;
		try {
			open = new jgitOpen(URI);
			Git git = open.getGit();
			Repository repository = git.getRepository();

			RevWalk walk = new RevWalk(repository);
			ObjectId id = repository.resolve(CommitHash);
			RevCommit commit = walk.parseCommit(id);
			
			printCommitStatus(commit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printCommitStatus(RevCommit commit) {
		
		System.out.println(commit.name());
		System.out.println(commit.getCommitterIdent().getName());
		System.out.println(commit.getCommitterIdent().getEmailAddress());
		System.out.println(commit.getCommitTime());
	}

}
