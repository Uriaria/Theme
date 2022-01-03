package object;

public class Character {
	private String name;
	private int hp;
	private int mp;
	private int no;
	
	public Character() {
    }
    public void setName(Character[] ch, String name, int index) {
    	ch[index].name = name;
    }
    public String getName(Character[] ch, int index) {
    	return ch[index].name;
    }
    public void setHp(Character[] ch, int hp, int index) {
    	ch[index].hp = hp;
    }
    public int getHp(Character[] ch, int index) {
    	return ch[index].hp;
    }
    public void setMp(Character[] ch, int mp, int index) {
    	ch[index].mp = mp;
    }
    public int getMp(Character[] ch, int index) {
    	return ch[index].mp;
    }
    public void setNo(Character[] ch, int no, int index) {
    	ch[index].no = no;
    }
    public int getNo(Character[] ch, int index) {
    	return ch[index].no;
    }
}
