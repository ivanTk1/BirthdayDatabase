package for_proj3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Iterator;

public class PersonList  {
		
		LinkedList<Person> list = new LinkedList<Person>();

	    public boolean add(Person p) {
			if (!list.contains(p)) {
	            list.add(p);
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean addAlpha(Person p) {
	        if (!list.contains(p)) {
	            list.addAlpha(p);
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public String saveToFile(String fileName) {
	    	 String messageFromSave = "";
	    	 try {
	    	   ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
	    	   for(int i = 0; i < list.size(); i++) {
	    	    oOS.writeObject(list.get(i));
	    	   }
	    	   oOS.flush();
	    	   oOS.close();
	    	 }catch(Exception e) {
	    	   messageFromSave = e.toString();
	    	 }
	    	  return messageFromSave;
	    	}

	    	public String loadFromFile(String fileName) {
	    	  String toReturn = ""; 
	    	  try{
	    	     ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
	    	     while(oIS.available() > -1) {
	    	       Person fromFile = (Person)(oIS.readObject());
	    	       Person found = search(fromFile);
	    	       if(found == null) {
	    	         if(add(fromFile)) {
	    	             toReturn += fromFile + "\n";
	    	        }else {
	    	             toReturn += fromFile + " not successfully added to DB.\n";
	    	        }
	    	      }else {
	    	        toReturn += found + " already in the DB.\n";
	    	      }
	    	   }
	    	   oIS.close();
	    	   }catch (EOFException eOF){
	    	   }
	    	   catch(Exception e) {
	    	      toReturn += e;
	    	   }
	    	   return toReturn;
	    	}


	        public Person search(Person p) {
	            if (list.contains(p)) {
	                return p;
	            }
	            return null;
	        }

	        public boolean delete(Name n) {
	            Iterator<Person> iter = list.iterator();
	            while (iter.hasNext()) {
	                Person p = iter.next();
	                if (p.getName().equals(n)) {
	                    iter.remove();
	                    return true;
	                }
	            }
	            return false;
	        }

	        public String hasBirthdayOn(Date date) {
	            for (Person p : list) {
	                if (p.getDate().equals(date)) {
	                    return p.toString();
	                }
	            }
	            return "Nobody has a birthday on that date.";
	        }

	        public String printList() {
	            StringBuilder sb = new StringBuilder();
	            for (Person p : list) {
	                sb.append(p.toString()).append("\n");
	            }
	            return sb.toString();
	        }

	        public String sortAlphab() {
	            return printList();
	        }
	        
	        public static Node<Person> copyLinkedList(Node<Person> head) {
	            if (head == null) {
	                return null;
	            }	            
	            Node<Person> newHead = new Node<Person>(head.getData());
	            
	            Node<Person> current = head;
	            Node<Person> newCurrent = newHead;
	            while (current.getLink() != null) {
	                current = current.getLink();
	                Node<Person> newNode = new Node<Person>(current.getData());
	                newCurrent.setLink(newNode);
	                newCurrent = newCurrent.getLink();
	            }
	            
	            return newHead;
	        }

	        //FIX THIS ): NOW WORKS WOOHOO
	        public String sortChronol() {
	            Node<Person> head = copyLinkedList(list.getHead());
	            Node<Person> sortedHead = mergeSort(head, new ChronoComparator());
	            LinkedList<Person> newList = new LinkedList<>();
	            for (Node<Person> node = sortedHead; node != null; node = node.getLink()) {
	                newList.add(node.getData());
	            }
	            StringBuilder sb1 = new StringBuilder();
	            for (Person p : newList) {
	                sb1.append(p.getName()).append(", ").append(p.getDate()).append("\n");
	            }
	            return sb1.toString();
	        }

	        private Node<Person> mergeSort(Node<Person> head, Comparator<Person> comparator) {
	            if (head == null || head.getLink() == null) {
	                return head;
	            }
	            Node<Person> middle = getMiddle(head);
	            Node<Person> nextOfMiddle = middle.getLink();
	            middle.setLink(null);
	            Node<Person> left = mergeSort(head, comparator);
	            Node<Person> right = mergeSort(nextOfMiddle, comparator);
	            return merge(left, right, comparator);
	        }

	        private Node<Person> getMiddle(Node<Person> head) {
	            Node<Person> small = head;
	            Node<Person> big = head.getLink();
	            while (big != null && big.getLink() != null) {
	                small = small.getLink();
	                big = big.getLink().getLink();
	            }
	            return small;
	        }

	        private Node<Person> merge(Node<Person> left, Node<Person> right, Comparator<Person> comparator) {
	            if (left == null) {
	                return right;
	            }
	            if (right == null) {
	                return left;
	            }
	            if (comparator.compare(left.getData(), right.getData()) <= 0) {
	                left.setLink(merge(left.getLink(), right, comparator));
	                return left;
	            } else {
	                right.setLink(merge(left, right.getLink(), comparator));
	                return right;
	            }
	        }

	        
			public String findPersonByName(Name name) {
	        	String toReturn = "Name was not found";
	        	Iterator<Person> iter = list.iterator();
	            while (iter.hasNext()) {
	                Person p = iter.next();
	                if (p.getName().equals(name)) {
	                    toReturn = p.toString();
	                    break;
	                    
	                }
	            }
	            return toReturn;
	        }
	    
	}
