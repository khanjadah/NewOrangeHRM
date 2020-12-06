package practice;

/*Maven has clean life cycle and build lyfe cycle.
 * It also has site life cycle(Not important).
 * clean life cycle----1)Pre-clean.
 * 						2)clean.
 * 						3)post--clean.
 * Clean goal: is to delete any previous build directories and reinstall them.
 * Build life cycle:-- There are 9 phases.
 * If we call the latest phase, it will include all the previous phases.
 * Phase1)- Validate :check wether the project has all the information it needs.
 * phase2)- Initialize: Basically it starts setting up the properties for the biuld state.
 * phase3)-compile: it gets all the source code and translate it.
 * phase4)- Test compile:It compiles the source code for the test.
 * phase5)-	Test: it runs the profiles thats given, if no profile given ,it will run all @ test.
 * phase6)-- package: Once the all the test case passes/success it will create a package.
 * phase7)--verify:it gonna run the last checkup for the package to see if it is good. 
 * phase8)--Install: this is where its create a package in to ur local repositories.
 * phase9)-- deploy: it will now put in the remote reposiotories.
 *  
 */
		
public class MavenLyfeCycle {

}
