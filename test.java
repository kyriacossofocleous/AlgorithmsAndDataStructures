
public class test {
	public static void main(String[] args) {
		AssessmentSLL<Integer> list1=new AssessmentSLL<Integer>();
		AssessmentSLL<Integer> list2=new AssessmentSLL<Integer>();
		AssessmentSLL<Integer> list3=new AssessmentSLL<Integer>();
		AssessmentSLL<Integer> list4=new AssessmentSLL<Integer>();
		list1.insertTail(1);
		list1.insertTail(4);
		list1.insertTail(5);
		list1.insertTail(9);
		list1.insertTail(10);
		list1.insertTail(41);
		list2.insertTail(1);
		list2.insertTail(1);
		list2.insertTail(5);
		list2.insertTail(12);
		list2.insertTail(44);
		list3.insertTail(9);
		list3.insertTail(32);
		list3.insertTail(35);
		list4=list3.merge(list1,list2);
		list4.printFirstToLast();
	}
}
