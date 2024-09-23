package utilities;

public class Constants {

	public static class PlayerConstants{
		public static final int IDLE_1 = 0;
		public static final int IDLE_2 = 1;
		public static final int RUNNING_1 = 3;
		public static final int RUNNING_2 = 2;
		public static final int ATTACK_1 = 6;
		public static final int ATTACK_2 = 4;
		public static final int DEATH_1 = 7;
		public static final int DEATH_2 = 5;
		
		public static int getSpriteCells(int playerAction){
			switch(playerAction) {
			case IDLE_1:
			case IDLE_2:	
				return 2;
			case RUNNING_1:
			case RUNNING_2:	
				return 8;
			case ATTACK_1:
			case ATTACK_2:	
				return 5;
			case DEATH_1:
			case DEATH_2:	
				return 4;
			default:
				return 0;
			}
			
		}
	}
}
