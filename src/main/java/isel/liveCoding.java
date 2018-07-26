package isel;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

public class liveCoding {

	public static void main(String[] args) {
		String dir = "/Users/imseongbin/Documents/Java/jgit-example";

		try {

			Git git = Git.open(new File(dir));
			Repository repository = git.getRepository();
			
			/* git log */
			Iterable<RevCommit> logs = git.log()
                    .call();
            int count = 0;
            for (RevCommit rev : logs) {
                System.out.println(rev.getShortMessage() + ", "+rev);
                count++;
            }
            System.out.println("모든 커밋의 개수는: "+count +"개 입니다.");
            /*		*/
            
            
            /* add All to index , and commit them*/
//            git.add().addFilepattern(".").call();
//            git.commit()
//            //.setAll(true)
//            .setMessage("Happy ISEL~!")
//            .call();
            /*		*/
            
            
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
