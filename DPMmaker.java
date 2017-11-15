//스윙으로 인자를 받아올 수 있게 만들어야 함.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DPMmaker extends JFrame
{

	class user_Info 	//유저 정보 입력
	{
	public
		user_Info()
		{
			attackStatus = 0;
			guardBreak = 0;
			critStatus = 35;
		}

		int attackStatus;
		double guardBreak;
		double critStatus;
	}

	class Skill_Info 	//스킬 정보 입력
	{
	public		//무슨 함수를 넣어야 하는 것 일까?
		int coolTime;
		int Damage;
		int Skill_Persistence;
		int hitNum;
		double skill_Delay;
		char hotkey;

		Skill_Info()
		{
			coolTime = 0;
			Damage = 0;
			Skill_Persistence = 0;
			hitNum = 0;
			skill_Delay = 0;
		}

		Skill_Info(int inputC, int inputD, int inputS, int inputH, double input_s, char hotKey)
		{
			coolTime = inputC;
			Damage = inputD;
			Skill_Persistence = inputS;
			hitNum = inputH;
			skill_Delay = input_s;
			hotkey = hotKey;
		}//아마 이 안에서 Skill_Activate 객체를 선언해야 할 것 같다.

		Skill_Activate Skill = new Skill_Activate(hotkey);
	}
/*
	class passiveSkill extends Skill_Info 	//패시브 스킬인 경우
	{
	public
		int chanceAttack = 0;
	}
*/
	class Skill_Activate extends KeyAdapter		//스킬단축키 입력시 작동
	{
		Skill_Activate(char H)
		{
			hotKey = H;
		}

		public void KeyPressed(KeyEvent e)
		{
			Container c = getContentPane();
			c.setLayout(null);

			if (e.getKeyChar() == hotKey);//파일 경로를 받아와야 하나...? 역시 객체 선언하고 해야 한다.
			{
				ImageIcon img_Gunir = new ImageIcon("Gunir_Decend.png");
				JLabel imgLab = new JLabel(img_Gunir);
				imgLab.setLocation(350, 10);
				imgLab.setSize(200, 250);
				c.add(imgLab);

				setVisible(true);
			}
		}

		char hotKey;
	}

	DPMmaker()	//본문
	{
		setTitle("메이플 스토리 다크나이트 DPM 계산기");	//제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//완전종료
		setContentPane(new imagePanel());
		user_Info Job = new user_Info();		//유저 객체 생성


//--------------------------------------------------초기화 버튼 생성------------------------
		Container c = getContentPane();
		c.setLayout(null);	//이것으로 절대 위치를 조정하겠다.


		JButton _reset = new JButton();
		_reset.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)//여기에서 초기화 버튼 기능 구현.
				{
					JButton b = (JButton)e.getSource();
				}
			}
		);
		_reset.add(new JLabel("reset"));
		_reset.setLocation(10, 10);
		_reset.setSize(75, 30);
		_reset.setFont(new Font("CENTOR_BASELINE", Font.ITALIC, 50));
		c.add(_reset);


//-----------------------------입력창 생성-----------------------------------------

		JTextField _attackStatus = new JTextField();
	//	int input_attackStatus = Integer.parseInt(_attackStatus.getText().toString());
		_attackStatus.setLocation(110, 50);
		_attackStatus.setSize(200, 20);
		_attackStatus.add(new JTextField(16));
		JLabel __attackStatus = new JLabel("attack status");	//스공
		__attackStatus.setLocation(5, 50);
		__attackStatus.setSize(100, 20);
		JButton input_AS = new JButton("input");
	/*	input_AS.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JButton b = (JButton)e.getSource();
					Job.attackStatus = input_attackStatus;
				}
			}
		);
	*/
		input_AS.setLocation(120, 50);
		input_AS.setSize(75, 20);
		c.add(input_AS);


		JTextField _guardBreak = new JTextField();
		_guardBreak.setLocation(110, 75);
		_guardBreak.setSize(200, 20);
		_guardBreak.add(new JTextField(16));
		JLabel __guardBreak = new JLabel("guard break");	//방무
		__guardBreak.setLocation(5, 75);
		__guardBreak.setSize(100, 20);


		JTextField _critStatus = new JTextField();
		_critStatus.setLocation(110, 100);
		_critStatus.setSize(200, 20);
		_critStatus.add(new JTextField(16));
		JLabel __critStatus = new JLabel("crit status");	//크댐
		__critStatus.setLocation(5, 100);
		__critStatus.setSize(100, 20);

		c.add(_attackStatus);
		c.add(__attackStatus);
		c.add(_guardBreak);
		c.add(__guardBreak);
		c.add(_critStatus);
		c.add(__critStatus);


		Skill_Info Gunir_Decend = new Skill_Info(8, 225, 0, 12, 0.63, 'd');		//스킬 출력 실험

		setSize(600, 300);
		setVisible(true);
	}

	class imagePanel extends JPanel 	//이미지 출력
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.BLUE);
			g.drawRect(350, 10, 200, 250);
		}
	}

	public static void main(String [] args)
	{
		new DPMmaker();
	}
}