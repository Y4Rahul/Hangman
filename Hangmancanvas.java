package project;
import acm.graphics.*;
public class Hangmancanvas extends GCanvas {
	/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	/* scaffold */
	private GLine Scaffold;
	private GLine Beam;
	private GLine Rope;
	private GOval Head;
	private GLine Body;
	private GLine R_Arm;
	private GLine RL_Arm;
	private GLine LL_Arm;
	private GLine L_Arm;
	private GLine Hip;
	private GLine L_Leg;
	private GLine R_Leg;
	private GLine LL_Leg;
	private GLine RL_Leg;
	
	public void run() {
		int key=8;
		setup();
		remove_parts(key);
	}

	private void setup() {
		
		/*SETTING POSITION OF ALL INSTANCE VARIABLE*/
		
		Scaffold = new GLine(50,25, 50, SCAFFOLD_HEIGHT);
		Beam = new GLine(50,25,BEAM_LENGTH,25);
		Rope = new GLine(BEAM_LENGTH,25,BEAM_LENGTH,25+ROPE_LENGTH);
		Head = new GOval(2*HEAD_RADIUS,2*HEAD_RADIUS);
		Body = new GLine(BEAM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS,BEAM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		L_Arm = new GLine(BEAM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,UPPER_ARM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		R_Arm = new GLine(BEAM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,BEAM_LENGTH+UPPER_ARM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		LL_Arm = new GLine(UPPER_ARM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,UPPER_ARM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		RL_Arm = new GLine(BEAM_LENGTH+UPPER_ARM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,BEAM_LENGTH+UPPER_ARM_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		Hip = new GLine(BEAM_LENGTH-(HIP_WIDTH),25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,BEAM_LENGTH+HIP_WIDTH,25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		L_Leg = new GLine(BEAM_LENGTH-(HIP_WIDTH),25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,BEAM_LENGTH-(HIP_WIDTH),25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		R_Leg = new GLine(BEAM_LENGTH+HIP_WIDTH,25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,BEAM_LENGTH+HIP_WIDTH,25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		LL_Leg = new GLine(BEAM_LENGTH-(HIP_WIDTH),25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,BEAM_LENGTH-(HIP_WIDTH)-FOOT_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		RL_Leg = new GLine(BEAM_LENGTH+HIP_WIDTH,25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,BEAM_LENGTH+HIP_WIDTH+FOOT_LENGTH,25+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		
		/* ADDING ALL COMPONENTS TO GRAPHICS*/
		add(Scaffold);
		add(Beam);
		add(Rope);
		add(Head,BEAM_LENGTH-(HEAD_RADIUS),25+ROPE_LENGTH);
		add(Body);
		add(L_Arm);
		add(R_Arm);
		add(LL_Arm);
		add(RL_Arm);
		add(Hip);
		add(L_Leg);
		add(R_Leg);
		add(LL_Leg);
		add(RL_Leg);
	}
	
	public void remove_parts(int i)
	{
		switch(i)
		{
		case 8: break;
		case 7: remove(LL_Leg);
				break;
		case 6: remove(RL_Leg);
				break;
		case 5: remove(L_Leg);
				break;
		case 4: remove(R_Leg);
				break;
		case 3:	remove(Body);
				break;
		case 2: remove(L_Arm);
				remove(LL_Arm);
				break;
		case 1: remove(R_Arm);
				remove(RL_Arm);
				break;
		case 0: removeAll();
				break;
		}
	}
}
