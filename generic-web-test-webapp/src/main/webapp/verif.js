function verifRequired(chExpr,zone)
{
	var longueur = chExpr.length;
	if(longueur ==0 ) {
		   alert("information "+ zone.name + " requise (ne doit pas rester vide)");
		   zone.focus();     
		   return false;
	           }
	return true;	
}

function verifNum(chExpr,zone)
{
var res=true
/*
var i, c
if(chExpr.length==0) res=false
for(i=0;i<chExpr.length;i++)
	{
	c=chExpr.charAt(i)
	if( c < '0' || c > '9') res=false
	}
*/
if(isNaN(chExpr)) res=false;
if(res==false)
        if(zone != null) 
	{
	alert("erreur saisie, " + zone.name +  " non numérique");
	zone.select(); zone.focus()
	}
	else alert("erreur saisie, zone non numérique");
return res;
}

function verifEmail(chExpr)
{
var pos = chExpr.indexOf("@");
if(pos <0 ) {
	   alert("il faut un @ dans un email !!");
            return false;
           }
return true;
}

function verifEntre(val,v1,v2)
{
if(val < v1 || val > v2) 
   {
    alert(val + " n'est pas compris entre " + v1 + " et " + v2 );	
    return false; 
   }
return true;
}

function verifMin(val,v1)
{
if(val < v1 ) 
   {
    alert(val + " ne doit pas être inférieur à " + v1 );	
    return false; 
   }
return true;
}

function verifMax(val,v1)
{
if(val > v1 ) 
   {
    alert(val + " ne doit pas être supérieur à " + v1 );	
    return false; 
   }
return true;
}
