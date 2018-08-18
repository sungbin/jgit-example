package edu.handong.isel.jgit.command;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.blame.BlameResult;
import org.eclipse.jgit.diff.RawText;
import org.eclipse.jgit.diff.RawTextComparator;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.revwalk.RevCommit;

import edu.handong.isel.jgit.jgitOpen;

public class git_blame {
	public static void main(String[] args) {
		String URI = null; // local git repository
		URI = ".";

		String exampleFile = "src/main/java/edu/handong/isel/jgit/jgitOpen.java";

		jgitOpen open;
		try {
			open = new jgitOpen(URI);
			Git git = open.getGit();

			System.out.println("Blaming " + exampleFile);
			final BlameResult result = git.blame().setFilePath(exampleFile)
					.setTextComparator(RawTextComparator.WS_IGNORE_ALL).call();

			final RawText rawText = result.getResultContents();
			for (int i = 0; i < rawText.size(); i++) {
				final PersonIdent sourceAuthor = result.getSourceAuthor(i);
				final RevCommit sourceCommit = result.getSourceCommit(i);
				System.out.println(sourceAuthor.getName()
						+ (sourceCommit != null ? "/" + sourceCommit.getCommitTime() + "/" + sourceCommit.getName()
								: "")
						+ ": " + rawText.getString(i));
			}
		} catch (Exception e) {
		}
	}
}
