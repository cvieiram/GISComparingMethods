package complexity.eafit;

import java.util.*;

public class MainTest {
	/*
	 * Generates the list of Elements with random coords and incremental id.
	 */
	public static Element[] populate( int numElements, int numCoords, int maxCoord)
	{
		Element list[]=new Element[numElements];
		float coords[];
		for (int i = 0; i < list.length; i++) {
			coords=new float[numCoords];
			for (int j = 0; j < numCoords; j++) {
				coords[j]=(float) (Math.round(Math.random()*maxCoord));
			}
			Element objElement=new Element(i, coords);
			list[i]=objElement;
		}
		return list;
	}
	
	
	
	public static void main(String args[]){
//		Element list[]=new Element[5];
//		
//		Element el1=new Element(0, new float[]{37,9});
//		list[0]=el1;
//		el1=new Element(2, new float[]{30,13});
//		list[1]=el1;
//		el1=new Element(4, new float[]{13,28});
//		list[2]=el1;
//		el1=new Element(7, new float[]{23,5});
//		list[3]=el1;
//		el1=new Element(8, new float[]{22,23});
//		list[4]=el1;
		int numCoords=3;
		Element list[]=MainTest.populate(10000, numCoords, 1000);
		ElementFinder objElementFinder= new ElementFinder();
		RTreeFinder objRTreeFinder= new RTreeFinder();
		objRTreeFinder.initialize(list, numCoords);
		objElementFinder.initialize(list, numCoords);
		float coords[]={20, 90,25};
		Element objElement= new Element(10,coords);
		long b = System.currentTimeMillis();
		List<Integer> resultList=objElementFinder.search(objElement, 30);
		System.out.println("Tiempo: "+ (System.currentTimeMillis()-b));
		
		for (Integer integer : resultList) {
			System.out.println(integer);
		}
		System.out.println("****");
		b = System.currentTimeMillis();
		List<Integer> resultList2=objRTreeFinder.search(objElement,30);
		System.out.println("TiempoRtree: "+ (System.currentTimeMillis()-b));

		for (Integer integer : resultList2) {
			System.out.println(integer);
		}
		//Test: Most Distant Points O(n) vs O(n^2) 
//		long b = System.currentTimeMillis();
//		objElementFinder.getMostDistantElements(objElementFinder.listElements);
//		System.out.println(System.currentTimeMillis()-b);
//		b = System.currentTimeMillis();
//		objElementFinder.getMostDistantSlow(objElementFinder.listElements);
//		System.out.println(System.currentTimeMillis()-b);
		
		
//		for (int i = 0; i < list.length; i++) {
//			System.out.println(list[i].getId());
//		}
//		for (Element element : objElementFinder.getMostDistantElements(list)) {
//			System.out.println(element.getId());
//		}
//		for (int i = 0; i < objElementFinder.listElements.length; i++) {
//			System.out.print("id: "+objElementFinder.listElements[i].getId()+" ");
//			for (int j = 0; j < objElementFinder.listElements[i].getCoords().length; j++) {
//				System.out.print("coord: "+i+" "+objElementFinder.listElements[i].getCoords()[j]+" - ");
//			}
//			System.out.print("\n");
//		}
//		Element minAndMax[]=objElementFinder.getMostDistant(objElementFinder.listElements);
//		System.out.println(minAndMax[0].getId());
//		System.out.println(minAndMax[1].getId());
//		objElementFinder.insertElements();
//		float coords[]={10, 20};
//		Element objElement= new Element(10500,coords);
//		List<Element> lista=objElementFinder.search(objElement, 14);
//		System.out.println("Arbol:");
//		System.out.println(objElementFinder.root.toString());
//		
//		System.out.println("Elementos cercanos:");
//		for (Element element : lista) {
//			System.out.println(element.getId());
//		}

//		System.out.println("hijo1: "+objElementFinder.root.children[0].objElement.getId());
//		System.out.println("hijo2: "+objElementFinder.root.children[1].objElement.getId());
//		if(objElementFinder.root.children[0].children[0]!=null)
//			System.out.println("hijo11: "+objElementFinder.root.children[0].children[0].objElement.getId());
//		
//		if(objElementFinder.root.children[0].children[1]!=null)
//			System.out.println("hijo12: "+objElementFinder.root.children[0].children[1].objElement.getId());
//		
//		if(objElementFinder.root.children[1].children[0]!=null)
//			System.out.println("hijo22: "+objElementFinder.root.children[1].children[0].objElement.getId());
//		
//		if(objElementFinder.root.children[1].children[1]!=null)
//			System.out.println(objElementFinder.root.children[1].children[1].objElement.getId());
		
	}
}
