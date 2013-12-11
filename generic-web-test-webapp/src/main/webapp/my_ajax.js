// reactualisation du contenu de la page HTML (<div id="..."> ou <span id="..."> ou ...)
// dont l'id est precise:
// utilisation :  var replayObj = new oReplayElem('div1');
//    	 	      replayObj._write(httpRequest.responseText);
function oReplayElem(id)
{
  this.elem  = document.getElementById(id);
  this._write = function(text){
  
    if(text == '' || text == null)
       text = 'Aucune Reponse';
      
    if(this.elem.innerHTML)
      this.elem.innerHTML = text;
    else{
      var txt = document.createTextNode(text);
      if(this.elem.firstChild) 
        this.elem.firstChild.data = txt.data;
      else 
        this.elem.appendChild(txt);
    }
  };
}

//Fonction callback declenchee au final via ajax:
function myAjaxCallBack(httpRequest,idZoneToRefresh) 
{ 
try{
if (httpRequest.readyState == 4 ) 
     { if (httpRequest.status == 200 || httpRequest.status == 0) 
            { 
    	      //alert(httpRequest.responseText); // en phase de test
    	 	  var replayObj = new oReplayElem(idZoneToRefresh);
    	 	  replayObj._write(httpRequest.responseText);
            } 
        else { 
               alert('Un probleme est survenu avec la requete. status='+httpRequest.status); }
      }
 }
 catch( e ) {
          alert("Une exception s'est produite : " + e.description);
      }

} 

//methode call() qui sera rattachee a l'objet MyAjaxCaller:
function makeAjaxRequest()
{
	var httpRequest=this.httpRequest;
	var idZone=this.idZone
	this.httpRequest.onreadystatechange = function() { 
		myAjaxCallBack(httpRequest,idZone);
	    }; 
	//NB: url complete = url_de_base de type xxxx?yyy=valy plus &zzzz=valZzz 
	// ou zzzz=valZZZ correspond a la nouvelle valeur du champ qui est a l'origine de l'appel ajax     
	this.httpRequest.open('GET', this.url+"&"+this.changedInput.name+"="+this.changedInput.value, true); 
	this.httpRequest.send(null); 
}

//methode d'initialisation initAjaxCaller() de la classe MyAjaxCaller:
function initHttpRequest() 
{ 
  //alert("debut initialisation httpRequest");	
  if (window.XMLHttpRequest) 
   { // Mozilla, Safari, IE7 , ... 
     this.httpRequest = new XMLHttpRequest();
    if (this.httpRequest.overrideMimeType) 
        { this.httpRequest.overrideMimeType('text/xml'); } 
   } 
 else if (window.ActiveXObject) 
    { 
      // IE5, IE6
        try { this.httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            } 
            catch (e) { try {  this.httpRequest = new ActiveXObject("Msxml2.XMLHTTP"); }
                         catch (e) { alert(e.description); } 
                      } 
    }
 if (!this.httpRequest) 
      { alert('Abandon :( Impossible de creer une instance XMLHTTP'); 
        return false; 
    }
 //alert("fin initialisation httpRequest , httpRequest="+this.httpRequest);
}


// class MyAjaxCaller 
//utilisation:  var ajc = new MyAjaxCaller('urlxxx?xxx=valXxx','div1',zoneOrigineQuiAChange);
//              ajc.call();
function MyAjaxCaller(ajaxUrl,idZoneAReactualiser,changedInput)
{
this.httpRequest=null;
this.changedInput=changedInput;
this.url=ajaxUrl;
this.idZone=idZoneAReactualiser;
this.call=makeAjaxRequest;
this.initAjaxCaller=initHttpRequest; // constructeur (initialisation)
this.initAjaxCaller();
}


//methode d'invocation rapide:
// ex: onChange='refreshViaAjax("w2ajax?bean=selectionBean&newHtmlContentFor=productId","span1",this)'
function refreshViaAjax(url,idZone,changedInput)
{
	var ajc = new MyAjaxCaller(url,idZone,changedInput);
	ajc.call();
}


