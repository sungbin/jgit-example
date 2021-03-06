package edu.handong.isel.jgit.specifics;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

import edu.handong.isel.jgit.jgitOpen;

public class recursiveAllCommit {
	public static void main(String[] args) {
		String URI = null; // local git repository
		URI = ".";

		jgitOpen open;
		try {
			open = new jgitOpen(URI);
			Git git = open.getGit();
			Repository repository = git.getRepository();
			
			Iterable<RevCommit> logs = git.log().call();

			for (RevCommit rev : logs) {
				RevCommit parent;
				if((parent = rev.getParent(0)) != null) {
					System.out.println("old: "+parent.getId().getName() +", new: " + rev.getId().getName());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
