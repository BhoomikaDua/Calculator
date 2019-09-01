package calculator;
import java.util.regex.*;

public class Compute
{
	char[] c;
	String[] b=new String[100];
	String[] bt=new String[100];
	String s;
	int z=0;
	float ans;
	String answer;
	
	Compute(String s)
	{
		this.s=s.replaceAll("\\s+", "");
		c=s.toCharArray();
		preprocess();
		// System.out.println("Answer:" + ans);
	    answer=Float.toString(ans);	     
	}
	
	 void preprocess()
	{
		Pattern pat=Pattern.compile("[0-9]+");
		Matcher mat=pat.matcher(s);
		int i=0;
		while(mat.find())
		{
		   b[i]=mat.group();
		   i+=2;		
		}
		
		
		int o=0;
        for(int j=0;j<c.length;j++)
		{
			if(!Character.isDigit(c[j]))
			{
		       bt[o]=Character.toString(c[j]);
			   o++;
			}
		
		}
	
        int p=1;
	for(int k=0;k<bt.length;k++)
	{
		if(p%2==1 && p<100)
		{
		b[p]=bt[k];
		p=p+2;
		}
		}
	
	
	for(int y=0;y<b.length;y++)
	{
		try {
			if(b[y].equals("."))
			{
				b[y-1]=b[y-1]+b[y]+b[y+1];
				for(int yy=y;yy<b.length-2;yy++)
				{
					b[yy]=b[yy+2];
				}
			}
		} catch (NullPointerException e) {
			
		}
	}
	
	int ig=0;
	while(b[ig]!=null)
	{
		z++;
	    ig++;
	}
	calculate(b);
	}
	
	
	
	void calculate(String[] q)
	{
		for(int x=1;x<z;x++)
		{
           try {
			if(q[x].equals("/") )
				{
					float n1,n2,n3;
					n1=Float.parseFloat(q[x-1]);
					n2=Float.parseFloat(q[x+1]);
					q[x+1]=null;
					n3=n1/n2;
					
					q[x-1]=Float.toString(n3);
					
					for(int ii=x;ii<z;ii++)
					{
						q[ii]=q[ii+2];
					}
					calculate(q);
				}
		} catch (NullPointerException e) {
			
		} }
       	  multiply(q);
	}
	
	
	void multiply(String[] q)
	{
		for(int x=1;x<z;x++)
		{
           try {
			if(q[x].equals("*") )
				{
					float n1,n2,n3;
					n1=Float.parseFloat(q[x-1]);
					n2=Float.parseFloat(q[x+1]);
					q[x+1]=null;
					n3=n1*n2;
					
					q[x-1]=Float.toString(n3);
					
					for(int ii=x;ii<z;ii++)
					{
						q[ii]=q[ii+2];
					}
					
					multiply(q);
				}
		} catch (NullPointerException e) {
			
		}
		}
       	  add(q);
	}
	
	void add(String[] q)
	{
		for(int x=1;x<z;x++)
		{
           try {
			if(q[x].equals("+") )
				{
					float n1,n2,n3;
					n1=Float.parseFloat(q[x-1]);
					n2=Float.parseFloat(q[x+1]);
					q[x+1]=null;
					n3=n1+n2;
					
					q[x-1]=Float.toString(n3);
					
					for(int ii=x;ii<z;ii++)
					{
						q[ii]=q[ii+2];
					
					}
					add(q);
				}
		} catch (NullPointerException e) {
			
		}    
		}
		
		
       	  subtract(q);
		
	
		
	}
	
	void subtract(String[] q)
	{
      for(int x=1;x<z;x++)
		{
           try {
			if(q[x].equals("-") )
				{
					float n1,n2,n3;
					n1=Float.parseFloat(q[x-1]);
					n2=Float.parseFloat(q[x+1]);
					q[x+1]=null;
					n3=n1-n2;
					
					q[x-1]=Float.toString(n3);
					
					for(int ii=x;ii<z;ii++)
					{
						q[ii]=q[ii+2];
					}
					subtract(q);
				}
		} catch (NullPointerException e) {
			
		}
		}
		
		 ans=Float.parseFloat(q[0]);
       	 }
		}


