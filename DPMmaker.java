//�������� ���ڸ� �޾ƿ� �� �ְ� ������ ��.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DPMmaker extends JFrame
{

	class user_Info 	//���� ���� �Է�
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

	class Skill_Info 	//��ų ���� �Է�
	{
	public		//���� �Լ��� �־�� �ϴ� �� �ϱ�?
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
		}//�Ƹ� �� �ȿ��� Skill_Activate ��ü�� �����ؾ� �� �� ����.

		Skill_Activate Skill = new Skill_Activate(hotkey);
	}
/*
	class passiveSkill extends Skill_Info 	//�нú� ��ų�� ���
	{
	public
		int chanceAttack = 0;
	}
*/
	class Skill_Activate extends KeyAdapter		//��ų����Ű �Է½� �۵�
	{
		Skill_Activate(char H)
		{
			hotKey = H;
		}

		public void KeyPressed(KeyEvent e)
		{
			Container c = getContentPane();
			c.setLayout(null);

			if (e.getKeyChar() == hotKey);//���� ��θ� �޾ƿ;� �ϳ�...? ���� ��ü �����ϰ� �ؾ� �Ѵ�.
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

	DPMmaker()	//����
	{
		setTitle("������ ���丮 ��ũ����Ʈ DPM ����");	//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//��������
		setContentPane(new imagePanel());
		user_Info Job = new user_Info();		//���� ��ü ����


//--------------------------------------------------�ʱ�ȭ ��ư ����------------------------
		Container c = getContentPane();
		c.setLayout(null);	//�̰����� ���� ��ġ�� �����ϰڴ�.


		JButton _reset = new JButton();
		_reset.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)//���⿡�� �ʱ�ȭ ��ư ��� ����.
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


//-----------------------------�Է�â ����-----------------------------------------

		JTextField _attackStatus = new JTextField();
	//	int input_attackStatus = Integer.parseInt(_attackStatus.getText().toString());
		_attackStatus.setLocation(110, 50);
		_attackStatus.setSize(200, 20);
		_attackStatus.add(new JTextField(16));
		JLabel __attackStatus = new JLabel("attack status");	//����
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
		JLabel __guardBreak = new JLabel("guard break");	//�湫
		__guardBreak.setLocation(5, 75);
		__guardBreak.setSize(100, 20);


		JTextField _critStatus = new JTextField();
		_critStatus.setLocation(110, 100);
		_critStatus.setSize(200, 20);
		_critStatus.add(new JTextField(16));
		JLabel __critStatus = new JLabel("crit status");	//ũ��
		__critStatus.setLocation(5, 100);
		__critStatus.setSize(100, 20);

		c.add(_attackStatus);
		c.add(__attackStatus);
		c.add(_guardBreak);
		c.add(__guardBreak);
		c.add(_critStatus);
		c.add(__critStatus);


		Skill_Info Gunir_Decend = new Skill_Info(8, 225, 0, 12, 0.63, 'd');		//��ų ��� ����

		setSize(600, 300);
		setVisible(true);
	}

	class imagePanel extends JPanel 	//�̹��� ���
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