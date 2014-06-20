
public class PatronMemento {
	public void main(String args[]){
		RegularClass regularClass = new RegularClass();
		regularClass.setData("First Report");
		System.out.println(regularClass.data);
		regularClass.makeBackup();
		regularClass.setData("Second Report");
		System.out.println(regularClass.data);
		regularClass.recoverBackup();
		System.out.println(regularClass.data);
	}
 
	public class Memento{
		public String memoryData;
 
		public Memento(String data){
			this.memoryData=data;
		}
 
		public String recoverOldInformation(){
			return memoryData;
		}
	}
 
	public class RegularClass{
		Memento memento;
		String data;
		public RegularClass(){
 
		}
		public void setData(String data){
			this.data = data;
		}
		public void makeBackup(){
			 memento = new Memento(data);
		}
		public void recoverBackup(){
			data = memento.recoverOldInformation();
		}
	}
}
