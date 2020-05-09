<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%String before_rate = (String) request.getAttribute("before_rate");
String after_rate = (String) request.getAttribute("after_rate");
String tname = (String) request.getAttribute("tname");

%>
<html lang="en">
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<title>4page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

@import url(https://fonts.googleapis.com/css?family=Raleway:600);
body { 
background: #0A122A; 
   font-family: 'Raleway', sans-serif;
   display: grid;
   grid-template-areas: 
    "header"
    "section";
   grid-template-rows: 1fr;
   grid-template-columns: 1fr;
   grid-gap: 5px;
  margin: 50px 350px;  
}

center{
  color: #0A122A;
  font-family: 'Raleway', sans-serif;
  font-size: 32px;
  font-weight: 900;
  text-transform: uppercase;
  text-align: center;
  letter-spacing: 0.3ex;
  text-transform: uppercase;
  margin: 5px;
}

header {
   background: #0A122A;
   grid-area: header;
     color: #fff;
  font-family: 'Raleway', sans-serif;
  font-size: 52px;
  font-weight: 600;
  text-transform: uppercase;
  text-align: center;
  letter-spacing: 0.3ex;
  margin: 50px;
}


.text{
  color: #fff;
  font-family: 'Raleway', sans-serif;
  font-size: 72px;
  font-weight: 600;
  text-transform: uppercase;
  text-align: center;
  letter-spacing: 0.3ex;
  text-transform: uppercase;
  text-shadow: 7px 5px rgb(255, 92, 51, 0.7);
}



nav {
   background: #ABABAB;
   grid-area: nav; 
   margin: 10px;    
}

section {
   background: #fff;
   border: 0px solid #fff;
   border-radius:0px;
   grid-area: section;
   height: auto;
}

footer1 {
   background: #0A122A;
   grid-area: footer1;
   height: 300px;
   margin: 1px;
}

footer2 {
   background: #0A122A;
   grid-area: footer2;
   height: 300px;
   margin: 1px 0px;   
}

header,  section, aside{
   padding: 30px;
}

nav, footer1, footer2 {
   padding: 0px;
}

.text > span.wrap::after {
  content: "|";
  color: #f61;
}


$colorBlue: rgb(56, 177, 204);
$colorGreen: rgb(44, 178, 153);
$colorViolet: rgb(142, 93, 159);

.box {
  float: left;
  background: rgba(0,0,0,0.13);
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
  padding: 9px 0px;
  font-size: 12px;
}

.skillBarContainer {
  width: 900px;
  max-width: 350px;
  height:30px;
  background: #e6eae3;
  background: rgba(8,102,220,.2);
  overflow: hidden;
  border-radius:5px;
  margin: auto;
  margin-bottom: 1px;
}


.skillBarContainer.green {
   background: #e6eae3;;
   background: rgb(29, 53, 124,.2);
   overflow: hidden;
   border-radius:5px;
   margin: auto;
   margin-bottom: 5px;
}

.skillBarContainer.violet {
   background: #e6eae3;;
   background:rgb(255, 92, 51,.2);
   overflow: hidden;
   border-radius:5px;
   margin: auto;
   margin-bottom: 5px;
}



.skillBarValue {
 height:100%;
  float: left;
  background:rgba(8,102,220);
  background: rgba(8,102,220,.75);
  text-align: right; /* Right-align text */
  color: white; /* White text color */
  margin: auto;
}


.skillBarValue.green {
  float: left;
  background:$colorGreen;
  background: rgb(29, 53, 124,.75);
  margin: auto;
  font-size: 20px;
}

.skillBarValue.violet {
  float: left;
  background:$colorViolet;
  background: rgb(255, 92, 51,.75);
  margin: auto;
  font-size: 20px;
}


/* Allowed values for the css skill bars */
.value-00  { width: 0;    }
.value-05  { width: 5%;    }
.value-10  { width: 10%;  }
.value-15  { width: 15%;  }
.value-20  { width: 20%;  }
.value-25  { width: 25%;  }
.value-30  { width: 30%;  }
.value-35  { width: 35%;  }
.value-40  { width: 40%;  }
.value-45  { width: 45%;  }
.value-50  { width: 50%;  }
.value-55  { width: 55%;  }
.value-60  { width: 60%;  }
.value-65  { width: 65%;  }
.value-70  { width: 70%;  }
.value-75  { width: 75%;  }
.value-80  { width: 80%;  }
.value-85  { width: 85%;  }
.value-90  { width: 90%;  }
.value-95  { width: 95%;  }
.value-100 { width: 100%; }

/*///////////////////////////////////////////////////
    // Animation \\ 
///////////////////////////////////////////////////*/
@-webkit-keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
@-moz-keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
@-ms-keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
@-o-keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
@keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
.skillBarValue {
  -webkit-animation: slideIn 2s;
  -moz-animation: slideIn 2s;
  -o-animation: slideIn 2s;
  animation: slideIn 2s;
}

.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #e7e7e7;
  border: none;
  color: #000000;
  text-align: center;
  font-size: 23px;
  width: 180px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  height: 50px;
  font-family: 'Raleway', sans-serif;
  font-weight: 300;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\2039';
  position: absolute;
  opacity: 0;
  top: 0;
  left: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-left: 25px;
}

.button:hover span:after {
  opacity: 1;
  left: 0;
}

.button1 {
  display: inline-block;
  border-radius: 4px;
  background-color: #ff5c33;
  border: none;
  color: #000000;
  text-align: center;
  font-size: 23px;
  width: 180px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  height: 50px;
  font-family: 'Raleway', sans-serif;
  font-weight: 300;
}

.button1 span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button1 span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button1:hover span {
  padding-right: 25px;
}

.button1:hover span:after {
  opacity: 1;
  right: 0;
}

</style>
</head>
<body>
<header><div class= "text" data-speed="150" data-period="2000"
    data-type='[ 
                  "RESULT"
                ]'></div></header>
  <section>
  <%if(Double.parseDouble(before_rate) <Double.parseDouble (after_rate)){ %>
  <center>before</center>
    <div class="skillBarContainer green">
      <div class="skillBarValue green value-55"><%=before_rate %>%&nbsp&nbsp</div>
    </div>   
    <br>
    <br>
  <center>after</center>
    <div class="skillBarContainer violet">
      <div class="skillBarValue violet value-80"><%=after_rate %>%&nbsp&nbsp</div>
      <%}else{ %>>
      
       <center>before</center>
    <div class="skillBarContainer green">
      <div class="skillBarValue green value-80"><%=before_rate %>%&nbsp&nbsp</div>
    </div>   
    <br>
    <br>
  <center>after</center>
    <div class="skillBarContainer violet">
      <div class="skillBarValue violet value-55"><%=after_rate %>%&nbsp&nbsp</div>
      <%} %>
    </div>
    <BR>
    </section>
</body>
<BR>
<BR>

<center>
<a href="Home.nam"><button class="button1" style="vertical-align:middle"><span>HOME</span></button></a>
</center>

<script>

window.onload = function() {
     let elements = document.getElementsByClassName('text');
     for (let i = 0; i < elements.length; ++i) {
       let messages = elements[i].getAttribute('data-type');
       let speed    = elements[i].getAttribute('data-speed');
       let period   = elements[i].getAttribute('data-period');
       if (messages) new Typewriter(elements[i], JSON.parse(messages), speed, period);
     }
   };

   function Typewriter(el, messages, speed, period) {
     this.el = el;
     this.messages = messages;
     this.speed  = parseInt(speed, 10)  || 200;
     this.period = parseInt(period, 10) || 2000;
     this.txt = '';
     this.loops = 0;
     this.isClearing = false;
     this.tick();
   }

   Typewriter.prototype.tick = function() {
     let msg  = this.messages[this.loops % this.messages.length];
     let edge = this.isClearing ? this.txt.length-1 : this.txt.length+1;
     this.txt = msg.substring(0, edge);
     this.el.innerHTML = '<span class="wrap">' + this.txt + '</span>';

     var delta = this.speed/2 + Math.random() * this.speed;
     if (this.isClearing) delta /= 2;

     if (!this.isClearing && this.txt === msg) {
       this.isClearing = true;
       delta = this.period;
     } else if (this.isClearing && this.txt === '') {
       this.loops++;
       this.isClearing = false;
       delta = this.period / 2;
     }
     setTimeout(() = this.tick(), delta);
   };

</script>





</html>