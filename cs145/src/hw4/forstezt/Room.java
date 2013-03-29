package hw4.forstezt;

import java.util.Scanner;

/**
 * creates a room of challenges for a player to overcome places the player in
 * the room and the rest is up to the user
 * 
 * @author Zach
 * 
 */
public class Room {

	/**
	 * asks the user their name and gender, then has them enter the room
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// asks the user what their name is
		System.out.println("Who are you?");
		String name = in.next();

		// asks the user their gender
		System.out.println("Are you a woman?");
		boolean isFemale = false;
		if (in.next().toLowerCase().equals("yes")) {
			isFemale = true;
		}

		// creates the player and enters the room
		Player player = new Player(name, isFemale);
		enter(player);
	}

	/**
	 * causes the player to enter the room, and then react to everything in it
	 * 
	 * @param player
	 *            the player, with a unique name and gender
	 * @return
	 */
	public static boolean enter(Player player) {
		Scanner in = new Scanner(System.in);

		boolean isInside = true;

		// prints out the user's first response after waking up in the room
		System.out
				.println("You wake up inside a dimly lit rectangular room. The light seems to be coming from above.");
		System.out
				.println("There is a ticking bomb chained to your right leg, attached by a padlock with a keyhole. A gun and a handsaw lay on the ground in front of you.");
		System.out
				.println("You think to yourself, \"Lets not panic! The best thing to do right now would be to check out my surroundings.\"");
		System.out
				.println("Through your excellent powers of observation, you observe that you are currently looking northward.");
		System.out
				.println("Hint: Please enter your commands in the form <verb noun>, or <verb>");

		// initializes boolean variables needed
		boolean hasKey = false;
		boolean isChained = true;
		boolean legIsAttached = true;
		boolean doorIsOpen = false;
		boolean isHandled = false;
		boolean skylightIsBroken = false;
		boolean keyIsBroken = false;

		// creates the objects within the room
		Handsaw handsaw = new Handsaw();
		Gun gun = new Gun(1);
		Lever yellowLever = new Lever();
		Lever redLever = new Lever();
		Lever blueLever = new Lever();
		Bear bear = new Bear();
		Assailant man = new Assailant();
		Bomb bomb = new Bomb(600);
		double timeRemaining;

		// enters the user input loop
		while (isInside) {

			// asks the user for a command
			System.out.println("> ");
			String line = in.nextLine();

			// checks to see if the timer on the bomb has run out yet, and if
			// so, returns false
			timeRemaining = bomb.checkTimeRemaining();
			if (timeRemaining <= 0) {
				System.out
						.println("You have run out of time. The bomb went off.");
				return false;
			}

			// creates line parser
			Scanner parser = new Scanner(line);

			// reads in the verb entered by the user
			String verb = "";
			if (parser.hasNext()) {
				verb = parser.next().toLowerCase();
			}

			// reads in the noun entered by the user
			String noun = "";
			if (parser.hasNext()) {
				noun = parser.next().toLowerCase();
			}

			// handles all possible situations in which the user wants to look
			// around the room
			if (verb.equals("look") || verb.equals("glance")
					|| verb.equals("turn") || verb.equals("view")) {
				// handles situations in which the user looks north
				if (noun.equals("north")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else if (!gun.isPickedUp() && !handsaw.isPickedUp()) {
						System.out
								.println("There is a gun and a handsaw laying on the floor.");
					} else if (!gun.isPickedUp() && handsaw.isPickedUp()) {
						System.out
								.println("There is a gun laying on the floor.");
					} else if (gun.isPickedUp() && !handsaw.isPickedUp()) {
						System.out
								.println("There is a handsaw laying on the floor.");
					} else {
						System.out
								.println("There is nothing of interest here.");
					}
					// handles situations in which the user looks south
				} else if (noun.equals("south")) {
					isHandled = true;
					if (!bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Shhhh! There is a bear sleeping behind you!");
					} else if (bear.isAwake() && bear.isAlive()) {
						System.out.println("Watch out! That bear is awake!");
					} else {
						System.out
								.println("Wow, you still can't believe you've managed to kill that bear!");
					}
					// handles situations in which the user looks east
				} else if (noun.equals("east")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else if (man.isInside()) {
						System.out
								.println("There's a door under the glass skylight.");
					} else {
						System.out
								.println("There's a door illuminated under the glass skylight.");
					}
					// handles situations in which the user looks west
				} else if (noun.equals("west")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						System.out
								.println("There are three levers:  one red, one blue, and one yellow.  Behind them on the wall, someone has painted a riddle on the wall.");
					}
				} else if (noun.equals("around") || noun.equals("about")
						|| noun.equals("")) {
					isHandled = true;
					System.out
							.println("In which direction would you like to look??");
					System.out
							.println("Hint: Because of your excellent sense of direction, you know which directions north, south, east, and west are.");
				}

				// handles situations in which the user tries to read something
			} else if (verb.equals("read")) {
				// handles situations in which the user reads the words on the
				// wall
				if (noun.equals("words") || noun.equals("sentence")
						|| noun.equals("riddle") || noun.equals("wall")
						|| noun.equals("message")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						System.out
								.println("The riddle says:  Although it may appear unseen, you'll have to pick the color green.");
					}
				}

				// handles situations in which the user tries to pull a lever
			} else if (verb.equals("pull") || verb.equals("crank")
					|| verb.equals("use")) {
				// handles situations in which the user is not specific about
				// the lever
				if (noun.equals("lever")) {
					isHandled = true;
					System.out
							.println("There are three levers... be more specific.");
					// handles situations in which the user pulls the red lever
				} else if (noun.equals("red")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						if (redLever.isThrown()) {
							redLever.throwOff();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						} else {
							redLever.throwOn();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						}
					}
					// handles situations in which the user pulls the blue lever
				} else if (noun.equals("blue")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						if (blueLever.isThrown()) {
							blueLever.throwOff();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						} else {
							blueLever.throwOn();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						}
					}
					// handles the situations in which the user pulls the yellow
					// lever
				} else if (noun.equals("yellow")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						if (yellowLever.isThrown()) {
							yellowLever.throwOff();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						} else {
							yellowLever.throwOn();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						}
					}
				}

				// handles situations in which the user tries to grab something
			} else if (verb.equals("take") || verb.equals("grab")
					|| verb.equals("snag") || verb.equals("sieze")
					|| verb.equals("snatch") || verb.equals("get")) {
				// handles situations in which the user tries to grab the gun
				if (noun.equals("gun") || noun.equals("weapon")
						|| noun.equals("pistol") || noun.equals("rifle")
						|| noun.equals("boomstick")) {
					isHandled = true;
					if (!gun.isPickedUp()) {
						if (bear.isAwake() && bear.isAlive()) {
							System.out
									.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
							return false;
						} else {
							gun.grab();
							System.out
									.println("The gun feels good in your hand, but it is a bit light...");
						}
					} else {
						System.out
								.println("You are already holding it, geeze.");
					}
					// handles situations in which the user tries to grab the
					// handsaw
				} else if (noun.equals("handsaw") || noun.equals("saw")
						|| noun.equals("blade")) {
					isHandled = true;
					if (!handsaw.isPickedUp()) {
						if (bear.isAwake() && bear.isAlive()) {
							System.out
									.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
							return false;
						} else {
							handsaw.grab();
							System.out
									.println("Oh boy... what are you planning to do with this...");
						}
					} else {
						System.out
								.println("You are already holding it, geeze.");
					}
				}

				// handles situations in which the user tries to unlock
				// something
			} else if (verb.equals("unlock") || verb.equals("free")
					|| verb.equals("release") || verb.equals("unfasten")
					|| verb.equals("unshackel")) {
				// handles situations in which the user tries to unlock the
				// chain
				if (noun.equals("chain") || noun.equals("chains")
						|| noun.equals("shackels") || noun.equals("bonds")
						|| noun.equals("lock") || noun.equals("padlock")
						|| noun.equals("shackel") || noun.equals("shackel")
						|| noun.equals("bomb")) {
					isHandled = true;
					if (legIsAttached) {
						if (hasKey) {
							if (bear.isAwake() && bear.isAlive()) {
								System.out
										.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
								return false;
							} else {
								isChained = false;
								System.out
										.println("Yes! You have separated yourself from the bomb, but it is still ticking...");
								System.out
										.println("Also, a man holding a riot shield and a wrench has opened the door and stepped into the light from the window. He seems to be guarding the door.");
								man.enter();
								doorIsOpen = true;
							}
						} else {
							System.out
									.println("You cannot unlock your chain without a key.");
						}
					} else {
						System.out
								.println("A fat lot of good that will do you now...");
					}
				}

				// handles situations in which the user tries to use the saw
			} else if (verb.equals("saw") || verb.equals("cut")
					|| verb.equals("sever") || verb.equals("remove")
					|| verb.equals("amputate") || verb.equals("hack")) {
				// handles situations in which the user tries to saw his or her
				// leg
				if (noun.equals("leg") || noun.equals("right")
						|| noun.equals("limb") || noun.equals("foot")) {
					isHandled = true;
					if (handsaw.isPickedUp()) {
						if (!isChained) {
							System.out
									.println("Why would you cut off you leg? You're already free.");
						} else {
							if (handsaw.isBroken()) {
								System.out
										.println("How ridiculous! You could never cut something with a broken handsaw!");
							} else if (bear.isAwake() && bear.isAlive()) {
								System.out
										.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
								return false;
							} else if (bear.isAlive() && !bear.isAwake()) {
								legIsAttached = false;
								bear.wakeUp();
								System.out
										.println("Oh dear lord! You've cut yourself out of the chain, but your screams of agony have awoken the bear!!");
								System.out
										.println("Also, a man holding a riot shield and a wrench has opened the door and stepped into the light from the window. He seems to be guarding the door.");
								man.enter();
								doorIsOpen = true;
							} else {
								legIsAttached = false;
								System.out
										.println("Oh dear lord! You've cut yourself out of the chain, but you have never experienced anything so painful!!");
								System.out
										.println("Also, a man holding a riot shield and a wrench has opened the door and stepped into the light from the window. He seems to be guarding the door.");
								man.enter();
								doorIsOpen = true;
							}

						}
					} else {
						System.out.println("You don't have the handsaw yet.");
					}
					// handles situations in which the user tries to saw the
					// chain
				} else if (noun.equals("chain") || noun.equals("chains")
						|| noun.equals("shackels") || noun.equals("bonds")
						|| noun.equals("lock") || noun.equals("padlock")
						|| noun.equals("shackel")) {
					isHandled = true;
					if (handsaw.isPickedUp()) {
						if (!isChained) {
							System.out
									.println("Why would you cut the chain? You're already free.");
						} else {
							if (handsaw.isBroken()) {
								System.out
										.println("How ridiculous! You could never cut something with a broken handsaw!");
							} else if (bear.isAwake() && bear.isAlive()) {
								System.out
										.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
								return false;
							} else {
								System.out
										.println("What an awful idea! You have broken the handsaw!");
								handsaw.breakHandsaw();
							}
						}
					} else {
						System.out.println("You don't have the handsaw yet.");
					}
				}

				// handles situations in which the user tries to shoot or kill
				// something
			} else if (verb.equals("shoot") || verb.equals("kill")
					|| verb.equals("attack") || verb.equals("break")
					|| verb.equals("shatter") || verb.equals("murder")
					|| verb.equals("destroy")) {
				// handles situations in which the user tries to kill the bear
				if (noun.equals("bear")) {
					isHandled = true;
					if (bear.isAlive()) {
						if (gun.isPickedUp()) {
							if (gun.numberOfBullets() > 0) {
								gun.shoot();
								bear.die();
								System.out
										.println("Wow! You can't believe you just killed that thing.");
							} else {
								System.out
										.println("Without bullets, you attempt to defeat the bear in hand to hand combat. You are not victorious...");
								return false;
							}
						} else {
							System.out
									.println("Without a gun, you attempt to defeat the bear in hand to hand combat. You are not victorious...");
							return false;
						}
					} else {
						System.out
								.println("The bear is already dead, now you're just being excessive!");
					}
					// handles situations in which the user tries to kill the
					// man
				} else if (noun.equals("man") || noun.equals("person")
						|| noun.equals("guard") || noun.equals("guy")
						|| noun.equals("dude")) {
					isHandled = true;
					if (man.isAlive()) {
						if (gun.isPickedUp()) {
							if (gun.numberOfBullets() > 0) {
								if (bear.isAwake() && bear.isAlive()) {
									System.out
											.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
									return false;
								} else if (!bear.isAwake() && bear.isAlive()) {
									gun.shoot();
									bear.wakeUp();
									System.out
											.println("Your bullet bounced off of the guard's riot shield. He remains unharmed. Also, you have foolishly awoken the bear!!");
								} else {
									gun.shoot();
									System.out
											.println("Your bullet bounced off of the guard's riot shield. He remains unharmed.");
								}
							} else {
								System.out
										.println("Without bullets, you attempt to defeat the man in hand to hand combat. He clubs you... a lot...");
								return false;
							}
						} else {
							System.out
									.println("Without a gun, you attempt to defeat the man in hand to hand combat. He clubs you... a lot...");
							return false;
						}
					} else {
						System.out
								.println("The man is already dead, now you're just being excessive!");
					}
					// handles situations in which the user tries to break the
					// skylight
				} else if (noun.equals("skylight") || noun.equals("window")
						|| noun.equals("glass") || noun.equals("moonroof")
						|| noun.equals("sunroof")) {
					isHandled = true;
					if (!skylightIsBroken) {
						if (gun.isPickedUp()) {
							if (gun.numberOfBullets() > 0) {
								if (bear.isAwake() && bear.isAlive()) {
									System.out
											.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
									return false;
								} else if (!bear.isAwake() && bear.isAlive()) {
									if (man.isInside()) {
										gun.shoot();
										System.out
												.println("The glass shatters, raining down on the unsuspecting guard below. He falls to the ground, lifeless.");
										System.out
												.println("The door is open behind him. Better hurry though, you woke up the bear.");
										man.die();
										bear.wakeUp();
									} else {
										gun.shoot();
										System.out
												.println("The glass shatters, raining down on the floor. What a useless endevor, and now the bear is awake...");
										bear.wakeUp();
									}
								} else {
									if (man.isInside()) {
										gun.shoot();
										System.out
												.println("The glass shatters, raining down on the unsuspecting guard below.");
										System.out
												.println("He falls to the ground, lifeless. The door is open behind him.");
										man.die();
									} else {
										gun.shoot();
										System.out
												.println("The glass shatters, raining down on the floor. What a useless endevor...");
									}
								}
							} else {
								System.out
										.println("There is no way you could break that window without any bullets...");
							}
						} else {
							System.out
									.println("There is no way you could break that window without a gun...");
						}
					} else {
						System.out
								.println("Don't you remember?? You already broke that skylight.");
					}
				}

				// handles situations in which the user tries to check something
			} else if (verb.equals("inspect") || verb.equals("examine")
					|| verb.equals("watch")) {
				// handles situations in which the user tries to check the bomb
				// timer
				if (noun.equals("clock") || noun.equals("bomb")
						|| noun.equals("time") || noun.equals("timer")) {
					isHandled = true;
					if (bear.isAlive() && bear.isAwake()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						System.out
								.println("Seconds left before the bomb blows:  "
										+ bomb.checkTimeRemaining());
					}
					// handles situations in which the user checks the ammo in
					// the gun
				} else if (noun.equals("gun") || noun.equals("ammo")
						|| noun.equals("ammunition") || noun.equals("bullets")
						|| noun.equals("cartridge") || noun.equals("magazine")
						|| noun.equals("mag") || noun.equals("mags")) {
					isHandled = true;
					if (gun.isPickedUp()) {
						if (bear.isAwake() && bear.isAlive()) {
							System.out
									.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
							return false;
						} else if (gun.isPickedUp()) {
							System.out.println("Your ammunition count:  "
									+ gun.numberOfBullets());
						}
					} else {
						System.out
								.println("How do you plan on checking the ammunition in a gun you don't even have??");
					}
				}

				// handles situations in which the user tries to end the program
			} else if (verb.equals("quit") || verb.equals("stop")
					|| verb.equals("terminate")) {
				return false;

				// handles situations in which the user tries to open something
			} else if (verb.equals("open")) {
				// handles situations in which the user tries to open the door
				if (noun.equals("door") || noun.equals("exit")) {
					isHandled = true;
					if (doorIsOpen && man.isAlive()) {
						System.out
								.println("You can't just walk past that guard!");
					} else if (doorIsOpen && !man.isAlive()) {
						System.out
								.println("The door is already open. You sprint out the door before the bear can touch you.");
						return true;
					} else {
						if (!keyIsBroken) {
							if (bear.isAwake() && bear.isAlive()) {
								System.out
										.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
								return false;
							} else {
								if (hasKey) {
									System.out
											.println("You try the key in the door, but it doesn't work. When you try to pull the key out, it breaks!");
									keyIsBroken = true;
								} else {
									System.out.println("The door is locked.");
								}
							}
						} else {
							System.out
									.println("You can't open anything with a broken key.");
						}
					}
					// handles situations in which the user tries to open the
					// padlock
				} else if (noun.equals("chain") || noun.equals("chains")
						|| noun.equals("shackels") || noun.equals("bonds")
						|| noun.equals("lock") || noun.equals("padlock")
						|| noun.equals("shackel") || noun.equals("bomb")) {
					isHandled = true;
					if (hasKey) {
						if (legIsAttached) {
							if (!keyIsBroken) {
								if (bear.isAwake() && bear.isAlive()) {
									System.out
											.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
									return false;
								} else {
									isChained = false;
									System.out
											.println("Yes! You have separated yourself from the bomb, but it is still ticking...");
									System.out
											.println("Also, a man holding a riot shield and a wrench has opened the door and stepped into the light from the window. He seems to be guarding the door.");
									man.enter();
									doorIsOpen = true;
								}
							} else {
								System.out
										.println("You can't open anything with a broken key.");
							}
						} else {
							System.out
									.println("A fat lot of good that will do you now...");
						}
					} else {
						System.out
								.println("You cannot unlock your chain without a key.");
					}
				}

				// handles more situations in which the user tries to open the
				// door
			} else if (verb.equals("try")) {
				// handles more situations in which the user tries to open the
				// door
				if (noun.equals("door") || noun.equals("exit")) {
					isHandled = true;
					if (doorIsOpen && man.isAlive()) {
						System.out
								.println("You can't just walk past that guard!");
					} else if (doorIsOpen && !man.isAlive()) {
						System.out
								.println("The door is already open. You sprint out the door before the bear can touch you.");
						return true;
					} else {
						if (!keyIsBroken) {
							if (bear.isAwake() && bear.isAlive()) {
								System.out
										.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
								return false;
							} else {
								if (hasKey) {
									System.out
											.println("You try the key in the door, but it doesn't work. When you try to pull the key out, it breaks!");
									keyIsBroken = true;
								} else {
									System.out.println("The door is locked.");
								}
							}
						} else {
							System.out
									.println("You can't open anything with a broken key.");
						}
					}
				}

				// handles more situations in which the user tries to check
				// something
			} else if (verb.equals("check")) {
				// handles more situations in which the user tries to open the
				// door
				if (noun.equals("door") || noun.equals("exit")) {
					isHandled = true;
					if (doorIsOpen && man.isAlive()) {
						System.out
								.println("You can't just walk past that guard!");
					} else if (doorIsOpen && !man.isAlive()) {
						System.out
								.println("The door is already open. You sprint out the door before the bear can touch you.");
						return true;
					} else {
						if (!keyIsBroken) {
							if (bear.isAwake() && bear.isAlive()) {
								System.out
										.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
								return false;
							} else {
								if (hasKey) {
									System.out
											.println("You try the key in the door, but it doesn't work. When you try to pull the key out, it breaks!");
									keyIsBroken = true;
								} else {
									System.out.println("The door is locked.");
								}
							}
						} else {
							System.out
									.println("You can't open anything with a broken key.");
						}
					}
					// handles more situations in which the user tries to check
					// the bomb timer
				} else if (noun.equals("clock") || noun.equals("bomb")
						|| noun.equals("time") || noun.equals("timer")) {
					isHandled = true;
					if (bear.isAlive() && bear.isAwake()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						System.out
								.println("Seconds left before the bomb blows:  "
										+ bomb.checkTimeRemaining());
					}
					// handles more situations in which the user tries to check
					// the ammo
				} else if (noun.equals("gun") || noun.equals("ammo")
						|| noun.equals("ammunition") || noun.equals("bullets")
						|| noun.equals("cartridge") || noun.equals("magazine")
						|| noun.equals("mag") || noun.equals("mags")) {
					isHandled = true;
					if (gun.isPickedUp()) {
						if (bear.isAwake() && bear.isAlive()) {
							System.out
									.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
							return false;
						} else if (gun.isPickedUp()) {
							System.out.println("Your ammunition count:  "
									+ gun.numberOfBullets());
						}
					} else {
						System.out
								.println("How exactly do you plan to check the ammunition in a gun you don't have??");
					}
				}

				// handles situations in which the user tries to speak
			} else if (verb.equals("speak") || verb.equals("plead")
					|| verb.equals("talk") || verb.equals("converse")
					|| verb.equals("yell") || verb.equals("scream")) {
				isHandled = true;
				if (bear.isAwake() && bear.isAlive()) {
					System.out.println("Talking will get you nowhere now.");
				} else if (!bear.isAwake() && bear.isAlive()) {
					System.out
							.println("Dear lord! Your incessant noise has awaken the bear!");
					bear.wakeUp();
				} else {
					System.out.println("There is no response.");
				}

				// handles situations in which the user tries to leave the room
			} else if (verb.equals("leave") || verb.equals("exit")
					|| verb.equals("run") || verb.equals("flee")
					|| verb.equals("escape")) {
				isHandled = true;
				if (doorIsOpen && !man.isAlive()) {
					System.out
							.println("You sprint out the door before the bear can touch you.");
					return true;
				} else {
					System.out.println("There's no way out.");
				}

			} else if (verb.equals("throw")) {
				if (noun.equals("leg") || noun.equals("limb")
						|| noun.equals("foot") || noun.equals("severed")) {
					isHandled = true;
					if (!legIsAttached) {
						if (bear.isAlive() && bear.isAwake()) {
							System.out
									.println("The bear accepts your offering and goes back to sleep.");
							bear.goToSleep();
						} else {
							System.out
									.println("There is no need to feed a bear in that state.");
						}
					} else {
						System.out
								.println("How are you planning on that away?!");
					}
					// handles situations in which the user is not specific
					// about the lever
				} else if (noun.equals("lever")) {
					isHandled = true;
					System.out
							.println("There are three levers... be more specific.");
					// handles situations in which the user pulls the red lever
				} else if (noun.equals("red")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						if (redLever.isThrown()) {
							redLever.throwOff();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						} else {
							redLever.throwOn();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						}
					}
					// handles situations in which the user pulls the blue lever
				} else if (noun.equals("blue")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						if (blueLever.isThrown()) {
							blueLever.throwOff();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						} else {
							blueLever.throwOn();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						}
					}
					// handles the situations in which the user pulls the yellow
					// lever
				} else if (noun.equals("yellow")) {
					isHandled = true;
					if (bear.isAwake() && bear.isAlive()) {
						System.out
								.println("Seconds after taking your eyes off of the awakened bear, it was upon you. Not much was left afterwards.");
						return false;
					} else {
						if (yellowLever.isThrown()) {
							yellowLever.throwOff();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						} else {
							yellowLever.throwOn();
							if (!redLever.isThrown() && blueLever.isThrown()
									&& yellowLever.isThrown() && !hasKey) {
								System.out
										.println("You hear a rumbling sound, and a key falls from the cieling and lands convieniently in your hand.");
								hasKey = true;
							} else {
								System.out
										.println("Hmmm... nothing seemed to happen.");
							}
						}

					}
				}

				// handles situations in which the user tries to throw his or
				// her leg to the bear
			} else if (verb.equals("toss") || verb.equals("feed")
					|| verb.equals("give") || verb.equals("offer")) {
				// handles situations in which the user tries to throw the leg
				// to the bear
				if (noun.equals("leg") || noun.equals("limb")
						|| noun.equals("foot") || noun.equals("severed")) {
					isHandled = true;
					if (!legIsAttached) {
						if (bear.isAlive() && bear.isAwake()) {
							System.out
									.println("The bear accepts your offering and goes back to sleep.");
							bear.goToSleep();
						} else {
							System.out
									.println("There is no need to feed a bear in that state.");
						}
					} else {
						System.out
								.println("How are you planning on that away?!");
					}
				}
				// handles situations in which the user needs help
			} else if (verb.equals("help")) {
				isHandled = true;
				System.out
						.println("Remember that commands must be entered in the form <verb noun>, or if there is no noun, <verb>.");
				System.out
						.println("If you have no idea what to do, try checking your surroundings again.  You started out facing north...");
			}

			// handles situations in which the user doesn't enter a valid
			// command
			if (!isHandled) {
				System.out.println("Sorry, I didn't understand that.");
			}

			// resets isHandled and closes the parser
			isHandled = false;
			parser.close();
		}
		return false;
	}
}