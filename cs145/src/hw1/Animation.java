package hw1;

//Imports the Animator and Figure classes
import cs145.s2011C.hw1.Animator;
import cs145.s2011C.hw1.Figure;

public class Animation {

	// Method that causes the stick figure to turn left and wave its right hand,
	// then turn right and wave its left hand
	private static double turnBothWaysAndWave(double keyframes,
			Animator animator, Figure man, double waveDuration,
			double waveArmUpDegrees, double waveArmDownDegrees,
			double turnDuration) {

		// Places the figure in the center of the window at keyframe 0.0
		animator.register(man, keyframes);

		// Figure turns to its left
		man.turn(45.0);

		// Advances keyframes
		keyframes = keyframes + turnDuration;
		animator.register(man, keyframes);

		// Loop that causes figure to wave its right hand
		for (int i = 1; i < 5; i++) {
			// Figure bends its right arm up
			man.bendRightArm(waveArmUpDegrees);

			// Advances keyframes
			keyframes = keyframes + waveDuration;
			animator.register(man, keyframes);

			// Figure bends its right arm down
			man.bendRightArm(waveArmDownDegrees);

			// Advances keyframes
			keyframes = keyframes + waveDuration;
			animator.register(man, keyframes);
		}

		// Figure turns to its right
		man.turn(-90.0);

		// Advances keyframes
		keyframes = keyframes + turnDuration;
		animator.register(man, keyframes);

		// Loop that causes the figure to wave its left hand
		for (int i = 1; i < 5; i++) {
			// Figure bends its left arm up
			man.bendLeftArm(waveArmUpDegrees);

			// Advances keyframes
			keyframes = keyframes + waveDuration;
			animator.register(man, keyframes);

			// Figure bends its left arm down
			man.bendLeftArm(waveArmDownDegrees);

			// Advances keyframes
			keyframes = keyframes + waveDuration;
			animator.register(man, keyframes);
		}

		// Figure turns to face front
		man.turn(45.0);

		// Advances keyframes
		keyframes = keyframes + turnDuration;
		animator.register(man, keyframes);

		return keyframes;

	}

	// Method that causes the stick figure to turn to the left (his left) and
	// walk out of the window
	private static double turnAndWalkAway(double keyframes, Animator animator,
			Figure man, double walkDistance, double walkingLegRaiseAngle,
			double walkingLegLowerAngle, double walkingArmRaiseAngle,
			double walkingArmLowerAngle, double walkDuration) {

		// The figure turns to its left
		man.turn(-90);

		// Loop that causes the figure to walk forward
		for (int i = 1; i < 10; i++) {
			// Figure bends its right leg and left arm up, and bends its left
			// leg and right arm down
			man.bendRightLeg(walkingLegRaiseAngle);
			man.bendLeftLeg(walkingLegLowerAngle);
			man.bendRightArm(walkingArmLowerAngle);
			man.bendLeftArm(walkingArmRaiseAngle);
			man.move(walkDistance);

			// Advances keyframes
			keyframes = keyframes + walkDuration;
			animator.register(man, keyframes);

			// Figure bends its right leg and left arm down, and bends its left
			// leg and right arm up
			man.bendRightLeg(walkingLegLowerAngle);
			man.bendLeftLeg(walkingLegRaiseAngle);
			man.bendRightArm(walkingArmRaiseAngle);
			man.bendLeftArm(walkingArmLowerAngle);
			man.move(walkDistance);

			// Advances keyframes
			keyframes = keyframes + walkDuration;
			animator.register(man, keyframes);
		}

		return keyframes;

	}

	// Method that makes the stick figure turn around and run back into the
	// window
	private static double runBackOnScreen(double turnDuration,
			double keyframes, Animator animator, Figure man,
			double runDistance, double runningLegRaiseAngle,
			double runningLegLowerAngle, double runningArmRaiseAngle,
			double runningArmLowerAngle, double runDuration) {

		// Figure turns around in a 180
		man.turn(180);

		// Loop that causes the stick figure to run back into the middle of the
		// window
		for (int i = 1; i < 7; i++) {
			// Figure bends its left leg and right arm up, and bends its right
			// leg and left arm down
			man.bendLeftLeg(runningLegRaiseAngle);
			man.bendRightLeg(runningLegLowerAngle);
			man.bendLeftArm(runningArmLowerAngle);
			man.bendRightArm(runningArmRaiseAngle);
			man.move(runDistance);

			// Advances keyframes
			keyframes = keyframes + runDuration;
			animator.register(man, keyframes);

			// Figure bends its left leg and right arm down, and bends its right
			// leg and left arm up
			man.bendLeftLeg(runningLegLowerAngle);
			man.bendRightLeg(runningLegRaiseAngle);
			man.bendLeftArm(runningArmRaiseAngle);
			man.bendRightArm(runningArmLowerAngle);
			man.move(runDistance);

			// Advances keyframes
			keyframes = keyframes + runDuration;
			animator.register(man, keyframes);
		}

		// Figure turns to face forward
		man.turn(90.0);

		// Advances keyframes
		keyframes = keyframes + turnDuration;
		animator.register(man, keyframes);

		return keyframes;
	}

	// Method that makes the stick figure wave both arms and spin in a 360
	private static void waveBothArmsAndSpin(double keyframes,
			double turnDuration, Figure man, Animator animator,
			double waveDuration, double waveArmUpDegrees,
			double waveArmDownDegrees) {

		// Loop that makes the stick figure wave both arms
		for (int i = 1; i < 6; i++) {
			animator.register(man, keyframes);

			// Figure bends both arms up
			man.bendRightArm(waveArmUpDegrees);
			man.bendLeftArm(waveArmUpDegrees);

			// Advances keyframes
			keyframes = keyframes + waveDuration;
			animator.register(man, keyframes);

			// Figure bends both arms down
			man.bendRightArm(waveArmDownDegrees);
			man.bendLeftArm(waveArmDownDegrees);

			// Advances keyframes
			keyframes = keyframes + waveDuration;
			animator.register(man, keyframes);
		}

		// Figure spins in a complete 360
		man.turn(360);

		// Advances keyframes
		keyframes = keyframes + turnDuration;
		animator.register(man, keyframes);
	}

	// Method that declares variables and combines all other methods
	public static void main(String[] args) {

		// Variable declarations to create the stick figure
		Animator animator = new Animator();
		Figure man = new Figure();

		// Declares the keyframes variable
		double keyframes = 0.0;

		// Waving variable declarations
		double waveDuration = 1.5;
		double waveArmUpDegrees = 45.0;
		double waveArmDownDegrees = -45.0;

		// Turning variable declarations
		double turnDuration = 4.0;

		// Walking variable declarations
		double walkDistance = 0.5;
		double walkingLegRaiseAngle = 35.0;
		double walkingLegLowerAngle = -35.0;
		double walkingArmRaiseAngle = 25.0;
		double walkingArmLowerAngle = -25.0;
		double walkDuration = 2.0;

		// Running variable declarations
		double runDistance = 0.75;
		double runningLegRaiseAngle = 40.0;
		double runningLegLowerAngle = -40.0;
		double runningArmRaiseAngle = 30.0;
		double runningArmLowerAngle = -30.0;
		double runDuration = 1.0;

		// Calling all of the methods (bringing everything together)
		turnBothWaysAndWave(keyframes, animator, man, waveDuration,
				waveArmUpDegrees, waveArmDownDegrees, turnDuration);
		turnAndWalkAway(36.0, animator, man, walkDistance,
				walkingLegRaiseAngle, walkingLegLowerAngle,
				walkingArmRaiseAngle, walkingArmLowerAngle, walkDuration);
		runBackOnScreen(turnDuration, 72.0, animator, man, runDistance,
				runningLegRaiseAngle, runningLegLowerAngle,
				runningArmRaiseAngle, runningArmLowerAngle, runDuration);
		waveBothArmsAndSpin(88.0, turnDuration, man, animator, waveDuration,
				waveArmUpDegrees, waveArmDownDegrees);

		// Sending the animation to the window
		animator.show();
	}
}
