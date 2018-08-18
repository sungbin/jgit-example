package edu.handong.isel.jgit.command;

import java.io.IOException;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.blame.BlameResult;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.diff.RawText;
import org.eclipse.jgit.diff.RawTextComparator;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.filter.PathFilter;

import edu.handong.isel.jgit.jgitOpen;

public class git_diff {

	public static void main(String[] args) {
		String URI = null; // local git repository
		URI = ".";

		String oldCommitHash = "f7b2c60c230ffea4902e24bd439c1e1bc4f33e67";
		String newCommitHash = "48ca8817a2040a774070164790038ccba7613998";

		jgitOpen open;
		try {
			open = new jgitOpen(URI);
			Git git = open.getGit();
			Repository repository = git.getRepository();

			AbstractTreeIterator oldTreeParser = prepareTreeParser(repository, oldCommitHash);
			AbstractTreeIterator newTreeParser = prepareTreeParser(repository, newCommitHash);

			List<DiffEntry> diff = git.diff().setOldTree(oldTreeParser).setNewTree(newTreeParser).call();

			for (DiffEntry entry : diff) {
				System.out.println("Entry: " + entry + ", from: " + entry.getOldId() + ", to: " + entry.getNewId());
				try (DiffFormatter formatter = new DiffFormatter(System.out)) {
					formatter.setRepository(repository);
					formatter.format(entry);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static AbstractTreeIterator prepareTreeParser(Repository repository, String objectId) throws IOException {
		try (RevWalk walk = new RevWalk(repository)) {
			RevCommit commit = walk.parseCommit(ObjectId.fromString(objectId));
			RevTree tree = walk.parseTree(commit.getTree().getId());

			CanonicalTreeParser treeParser = new CanonicalTreeParser();
			try (ObjectReader reader = repository.newObjectReader()) {
				treeParser.reset(reader, tree.getId());
			}

			walk.dispose();

			return treeParser;
		}
	}
}
