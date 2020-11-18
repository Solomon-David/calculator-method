class Calculator{
public String calc(String a){
String b="";
try{
if(a.charAt(0)=='-'){
a="0"+a;
}


String reg="[^0-9\\.]";
Pattern p=Pattern.compile(reg);
String []nu=p.split(a);
ArrayList<String> nums=new ArrayList<String>();
Collections.addAll(nums,nu);

int l=nums.size();
ArrayList<Float> num=new ArrayList<Float>();

for(int d=0;d<l;d++){
num.add(Float.parseFloat(nums.get(d)));
}
 String c="";
Matcher m=p.matcher(a);
for(int x=0;x<l;x++){
if(m.find()){
c+=m.group();
}
else{
b+=nums.get(x);
}
}
float sum=num.get(0);
for(int e=1;e<l;e++){

if(Character.toString(c.charAt(e-1)).equals("+")){
sum+=num.get(e);
}

else if(Character.toString(c.charAt(e-1)).equals("-")){
sum-=num.get(e);
}

else if(Character.toString(c.charAt(e-1)).equals("x")){
sum*=num.get(e);
}
/*else if(Character.toString(c.charAt(e-1)).equals("^")){

num.get(e)=Math.pow(num.get(e-1))
}*/

else if(Character.toString(c.charAt(e-1)).equals("÷")){
sum/=num.get(e);
}

b=Float.toString(sum);
}


}
catch(Exception e){
Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
}
return b;
}

}
