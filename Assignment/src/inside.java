import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class inside {
	

		
	public static void main(String[] args) throws IOException {
		
		File file= new File("Database.txt");// the file is defined
		if(!file.exists())//Ýf file not exist create new
			file.createNewFile();
		
		ArrayList<String> list= new ArrayList<String>();// the Arraylist is defined
		Scanner read=new Scanner(file);// Scanner is defined

		 Outside outside = new Outside();// Class is defined
	    while(read.hasNextLine())// All information write to list Arraylist
		{
	       String write=read.nextLine();
	        list.add(write);
		}
	    
	    read.close();
	    double sum=0;
		boolean out =true;
			while(out==true) // Continue until out equal to false
			{
				//create menu
				System.out.println("1- To Save students");
				System.out.println("2- To Search for students");
				System.out.println("3- To list students");
				System.out.println("4- To update the student");
				System.out.println("5- To delete the student");
				System.out.println("6- To see the student's average");
				System.out.println("7- To see the overall average");
				System.out.println("8- To sort students by averages");
				System.out.println("9- For the search method");
				System.out.println("0- To Exit");
				// 
				Scanner input = new Scanner(System.in);
				int a=input.nextInt();
						switch (a) 
							{
						
						case 1:
							// I took  all information from user and register
							double avarages=0;
							boolean out2=true;
							while(out2==true) // If any info wrong again to register 
							{			Scanner register =new Scanner(System.in);

													int ID1=1;
													if(list.size()!=0)
													ID1=Integer.valueOf(list.get(list.size()-9))+1;
													
													System.out.println("Enter Name Of Student");
													String name=register.nextLine();
													
													System.out.println("Enter Surname Of Student");
													String surname=register.nextLine();
													
													System.out.println("Enter The student's first exam grade.");
													int grade1=register.nextInt();
													
													System.out.println("Enter The student's second exam grade.");
													int grade2=register.nextInt();
													
													System.out.println("Enter The student's third exam grade.");
													int grade3=register.nextInt();
													
													System.out.println("Enter The student's fourth exam grade.");
													int grade4=register.nextInt();
													
													System.out.println("Enter the student's fifth exam grade.");
													int grade5=register.nextInt();
													//control all grade
													 if(grade1>100||grade2>100||grade3>100||grade4>100||grade5>100||grade1<0||grade2<0||grade3<0||grade4<0||grade5<0)
													{
														 System.out.println("The Registration  is not successful..");
														System.out.println("You should write between 0 to 100 for all grades.");
												    }
													 else
													{
															outside.setGPA(grade1,grade2,grade3,grade4,grade5);
															list.add(String.valueOf(ID1));
															list.add(name);
															list.add(surname);
															list.add(String.valueOf(grade1));
															list.add(String.valueOf(grade2));
															list.add(String.valueOf(grade3));
															list.add(String.valueOf(grade4));
															list.add(String.valueOf(grade5));
															list.add(String.valueOf(outside.getGPA()));
														
															 FileWriter yazdýr1 = new FileWriter(file);
															 for(int i=0;i<list.size();i++){
														           
																 yazdýr1.write(list.get(i)+"\n");
																 
															
														        }
															 	yazdýr1.close();
		
																System.out.println("Number "+ID1+" was assigned to the student.\nThe Registration  is successful..");
																out2=false;
													}
												
											 
								 
							 }
							
							 break;
									case 2:
										int search=0;// took all ID
										System.out.println("Enter the ID of the student.");
										Scanner entry =new Scanner(System.in);
										String ID=entry.nextLine();
										
										 for(int i=0;i<list.size();i+=9)
										    {//if equal write info
											    	if(list.get(i).equals(ID))
											    {
											    	
											    		System.out.println(list.get(i+1)+" "+list.get(i+2)+"\nClass grades;"+list.get(i+3)+","
											    				+ ""+list.get(i+4)+","+list.get(i+5)+","+list.get(i+6)+","+list.get(i+7)+""
											    				+ " \nAverage :"+list.get(i+8));
											    		search++;
											    	
											    	
											    }
										    }
										 if(search==0) 
										 {		
												System.out.println("The Wanted student was not found.");
										 }
										 
										break;
										
										
										
										
									case 3://list all info from list
											for(int i=0;i<list.size();i+=9)
										    {
												System.out.println("Number: "+list.get(i)+" Name :"+list.get(i+1)+" "+list.get(i+2)+" Class grades;"+list.get(i+3)+","
								    				+ ""+list.get(i+4)+","+list.get(i+5)+","+list.get(i+6)+","+list.get(i+7)+""
								    				+ "   Average :"+list.get(i+8));
										    }
										break;
									case 4:// took ID and update what the user want change
										int search2=0;
										System.out.println("Enter the ID of the student.");
										Scanner update =new Scanner(System.in);
										String ID2=update.nextLine();
										for(int i=0;i<list.size();i+=9)//enter all ID index and search
									    {
										    	if(list.get(i).equals(ID2))
										    {
										    		search2++;
										    }
									    }
										if(search2==0) 
										{
											System.out.println("The Wanted student was not found.");	
											
										}
										else 
										{			System.out.println("You should choose what you will change.");
													System.out.println("1-Name\n2-Surname\n3-First Grade"
															+ "\n4-Second Grade\n5-Thirt Grade\n6-Fourth Grade\n7-Fifth Grade");
													int choose=update.nextInt();
													update.nextLine();
													for(int i=0;i<list.size();i+=9)//enter all ID index and search
												    {
														if(list.get(i).equals(ID2))
													    {
															int show=choose+i;
															System.out.println("The information is "+list.get(show));
													    }
												    }
													
													System.out.println("The Information which you want to change");	
													String info=update.nextLine();
													
													System.out.println("Press Y if you want to change this information.");	
													String question=update.nextLine();
													
													if(question.equals("y")||question.equals("Y")) 
													{
														 for(int i=0;i<list.size();i+=9)
														    {
															    	if(list.get(i).equals(ID2))
															    {
															    		int result=choose+i;
																    	list.remove(result);
															    	    list.add(result,info);
															    	    
															    	    double class1=Double.valueOf(list.get(i+3));
																    	double class2=Double.valueOf(list.get(i+4));
																    	double class3=Double.valueOf(list.get(i+5));
																    	double class4=Double.valueOf(list.get(i+6));
																    	double class5=Double.valueOf(list.get(i+7));
																		
																    	outside.setGPA(class1, class2, class3, class4, class5);
																    	list.remove(i+choose+4);
																    	list.add(i+choose+4,String.valueOf(outside.getGPA()));
																		 
															    	    
															    	    break;
															    }
														    }
														 
														
														
														 FileWriter writeit = new FileWriter(file);
														 for(int i=0;i<list.size();i++){
													           
															 writeit.write(list.get(i)+"\n");
															 
														
													        }
														 read.close();
														 writeit.close();
														 System.out.println("The Student information was changed.");
													}
													else
														System.out.println("The Student has not been erased at your request.");
													 
										}
										break;
									case 5://took ID and remove information for this student
										int search1=0;
										System.out.println("Enter the ID of the student.");
										Scanner silme =new Scanner(System.in);
										String ID3=silme.nextLine();
										for(int i=0;i<list.size();i+=9)//enter all ID index and search
									    {
										    	if(list.get(i).equals(ID3))
										    {
										    		search1++;
										    }
									    }
										if(search1==0) 
										{
											System.out.println("The Wanted student was not found.");	
											
										}
										
										else 
										{
													System.out.println("Press Y if you want to delete it.");
													String check=silme.nextLine();
													
														if(check.equals("y")||check.equals("Y"))
													    {  
															 for(int i=0;i<list.size();i+=9)//enter all ID index and search
															    {
																    	if(list.get(i).equals(ID3))
																    {
																    		for(int sil=0;sil<9;sil++)//remove 9 times that line
																    		{
																    			list.remove(i);
																    			
																    		}
																    		
																    }
															    }
															 System.out.println("The student was deleted.");
															 FileWriter write2 = new FileWriter(file);//Write file all list again
															 
															 for(int i=0;i<list.size();i++){
														           
																 write2.write(list.get(i)+"\n");
																 
															
														        }
															 read.close();
															 write2.close();
													    
														}
																	 
														 else 
															 System.out.println("The student has not been erased at your request.");
															
										}
										 break;
									case 6:// took ID and show gpa from list
										int search4=0;
												System.out.println("Enter the ID of the student.");
												Scanner avarage =new Scanner(System.in);
												String ID4=avarage.nextLine();
												for(int i=0;i<list.size();i+=9)
											    {
												    	if(list.get(i).equals(ID4))
												    {
												    		search4++;
												    }
											    }
												
												if(search4==0) 
												{
													System.out.println("The Wanted student was not found.");	
													
												}
												else 
												{
															for(int i=0;i<list.size();i+=9) //enter all ID index and search
														    {
															    	if(list.get(i).equals(ID4))//When find write 3 information after that index
															    {
															    		System.out.println(list.get(i+1)+" "+list.get(i+2)+"\n Avarage : "+list.get(i+8));
															    }
														    }
												}
										break;
									case 7://took all gpa and take avarage of this gpa
										for(int i=0;i<list.size();i=i+9)//enter all ID index and search
									    {
								    		sum=sum+Double.valueOf(list.get(i+8));
									    }
										sum=sum/(list.size()/9);
									    System.out.println(sum);
												
										break;
									
									case 8:// compare between selection and bubble
										ArrayList<Double> selection= new ArrayList<Double>();
						       	     for(int i=8;i<list.size();i+=9)//enter all GPA index and search
						       	     {
						       	    	 selection.add(Double.valueOf(list.get(i)));  //Add all info selection arraylist
						       	     }
						       	     double temp=0;

						       	     System.out.println("Before Sort: "+selection);
						       	  Outside.start(); //timer start
						       	     for(int q=0;q<selection.size();q++)
						       	     {
						       	    	 double min=selection.get(q);
							                	     for(int j=q+1;j<selection.size();j++)
							                	     {
							                	    	 if(min>selection.get(j))
							                	    		 min=selection.get(j);  
							                	     }
							                	     for(int search5=0;search5<selection.size();search5++)
							                	     {
							                	    	 if(min==selection.get(search5))
							                	    	 {
							                	    		 temp=selection.get(q);
							                	    		 selection.remove(q);
							                	    		 selection.add(q,min);
							                	    		 selection.remove(search5);
							                	    		 selection.add(search5,temp);
							                	    	 }
							                	     }
							                	     
						       	     }
						       	     Outside.stop(); //timer stop
						       	     double result=Outside.getElapsedMilliseconds(); 
						       	   selection.clear();

							       	  ArrayList<Double> Bubble= new ArrayList<Double>();
						       	  
						       	     for(int i=8;i<list.size();i+=9)
						       	     {
						       	    	Bubble.add(Double.valueOf(list.get(i)));  
						       	     }

							       	  boolean a1=true;
							       	  Outside.start();
						       	     for(int repeat=0;repeat<Bubble.size();repeat++) 
						       	     {
						       	    	 if(a1!=true)
						       	    	 break;
						       	         a1=false;
						           	     for(int q=0;q<Bubble.size()-1;q++) 
						           	     {
						           	    	 		 
						               	    	 double first=Double.valueOf(Bubble.get(q));
						               	    	 double second=Double.valueOf(Bubble.get(q+1));
						               	    	 if(first>second)
						               	    	 {
						               	    		 a1=true;
						               	    		Bubble.remove(q);
						               	    		Bubble.add(q,second);
						               	    		Bubble.remove(q+1);
						               	    		Bubble.add(q+1, first);
						               	    	 }
						           	     }
						           	 }
							       	  Outside.stop();
						       	     System.out.println("After Sort:  "+Bubble);
						       	     double result2=Outside.getElapsedMilliseconds();
						       	     System.out.println("Selection sort ="+result+"\nBubble  Sort ="+result2);
						       	     //Compare 
						       	     if(result<result2)
						       	    	 System.out.println("Selection sort is faster than bubble sort.");
						       	     else if(result>result2)
						       	    	System.out.println("Bubble sort is faster than selection sort.");
							       	  else
							       		  System.out.println("Bubble  sort and Selection sort Same fast");
								       	 
						       	  Bubble.clear();
						       	     break;
									
									case 9:  // compare between binary and normal search
											
										boolean check=true;
											ArrayList<String> binarysearch=new ArrayList<String>(); 
											for(int i=0;i<list.size();i+=9)// take all number and we dont need sort because it has already sort
											{
												binarysearch.add(list.get(i));
											}
											
											System.out.println("We have Those Numbers;"+binarysearch);
											System.out.println("Which one do you want to search?");
											Scanner take=new Scanner(System.in);
											int key=take.nextInt();
									        int first=0;
									        int last=binarysearch.size()-1;  
									        int mid = (first + last)/2;  
									        
									        outside.start();
										   // Find to number with binary search
									        while( first <= last ){  
										      if ( Integer.valueOf(binarysearch.get(mid)) < key ){  
										        first = mid + 1;     
										      }else if ( Integer.valueOf(binarysearch.get(mid))==key){    
										        break;  
										      }else{  
										         last = mid - 1;  
										      }  
										      mid = (first + last)/2;  
										   }  
									        outside.stop();
										   if ( first > last ){  
										      check=false;
										   }  
										     double binary=Outside.getElapsedMilliseconds();
										     
									        outside.start();
									        
										     for(int i=0;i<binarysearch.size();i+=9)
												{
										    	 	if(key==Integer.valueOf(binarysearch.get(i)))
										    	 	{
										    	 		System.out.println("Element is found at index: "+i);
										    	 		break;
										    	 	}
												}outside.stop();

										      if(check==true) {
										    	  //compare to search
										        double binary2=Outside.getElapsedMilliseconds();
										        System.out.println("Binary search ="+binary);
										        System.out.println("Normal search ="+binary2);
										        if(binary<binary2)
										        System.out.println("Binary search was faster than normal search.");
										        else if(binary>binary2)
											        System.out.println("Normal search was faster than binary search.");
										        else 
											        System.out.println("Binary and normal search was same fast.");
										      }
										      else
											      System.out.println("Element is not found!");  
										
										break;
							case 0:
								out=false;input.close();
								break;
										
							}
						
						if(out==false)
							break;
						
					}	
			
				
				
				
			}      
		
	}
