class Calculator{
public static String calc(String a){
try{
if(a.charAt(0)=='-'){
a="0"+a;
}

else{
a="0+"+a;
}
String b="";
String reg="[\\(^A-Z^a-z^0-9\\.^√\\^]";
Pattern p=Pattern.compile(reg);
String []nu=p.split(a);
      
      for(int x=0; x<nu.length; x++){
      String nuw="";
if(nu[x].contains("√")){
  nu[x]=nu[x].replace("√","");   
    nu[x]=Math.sqrt(Double.parseDouble(nu[x]))+"";
        }
else if((nu[x].contains("^"))||(nu[x].contains("^")&&nu[x].contains("-"))){
   
 String[] half=nu[x].split("[\\^]");
 
 nu[x]=Math.pow(Double.parseDouble(half[0]), Double.parseDouble(half[1]))+"";
  
   }
        
/*else if(nu[x].contains("Sin(")){
          
   //nu[x]=nu[x].substring(nu[x].indexOf("Sin("), nu[x].indexOf(")"));
 nu[x]=nu[x].replace("Sin(", "");
          
          double d=Double.parseDouble(nu[x]);
          d=Math.sin(d);
          nu[x]=d+"";
    Toast.makeText(context, "yes", Toast.LENGTH_SHORT).show();
      }*/
      nu[x]=nu[x];
       
  };
      
ArrayList<String> nums=new ArrayList<String>();
Collections.addAll(nums,nu);
int l=nums.size();
float[] num=new float[l];
for(int d=0;d<l;d++){
num[d]=Float.parseFloat(nums.get(d));
}
 String c="";
Matcher m=p.matcher(a);
for(int x=0;x<l;x++){
if(m.find()){
c+=m.group();
}

}
float sum=num[0];
for(int e=1;e<l;e++){

if(Character.toString(c.charAt(e-1)).equals("+")){
sum+=num[e];
}

else if(Character.toString(c.charAt(e-1)).equals("-")){
sum-=num[e];
}

else if(Character.toString(c.charAt(e-1)).equals("x")){
sum*=num[e];
}

else if(Character.toString(c.charAt(e-1)).equals("÷")){
sum/=num[e];
}
else{
sum=num[0];
        }


b=new DecimalFormat("@@@@").format(sum)+"";
 b=Float.parseFloat(b)+"";
      }
return b;
}
catch(Exception e){
return e.toString();
}
}
}
