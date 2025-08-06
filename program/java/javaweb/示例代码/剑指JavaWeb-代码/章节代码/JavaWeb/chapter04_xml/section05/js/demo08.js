window.onload = function () {
	//当页面加载完成，需要绑定事件
	//根据id获取表格（table对象）
	var fruitTbl = document.getElementById("tb1_fruit");
	//获取表格中的所有行
	var rows = fruitTbl.rows;
	for(var i = 1; i < rows.length-1; i++){
		var tr = rows[i];
		//1.绑定鼠标悬浮以及离开时设置背景颜色事件
		tr.onmouseover = showBGColor;
		tr.onmouseout = clearBGColor;
		//获取tr这一行的所有单元格
		var cells = tr.cells;
		var priceTD = cells[1];
		//2.绑定鼠标悬浮在单价单元格变手势的事件
		priceTD.onmouseover = showHand;
	}
	
}

//当鼠标悬浮时，显示背景颜色
function showBGColor(){
	
	//event ：当前发生的事件
	//event.srcElement ：事件源
	//alert(event.srcElement)
	//alert(event.srcElement.tagName) --> TD
	if (event && event.srcElement && event.srcElement.tagName=="TD"){
		var td = event.srcElement;
		//td.parentElement  表示获取td的父元素  -->TR
		var tr = td.parentElement;
		//如果想要通过js代码设置某节点的样式，则需要加上.style
		tr.style.backgroundColor = "navy";
		
		//tr.cells表示获取这个tr中的所有的单元格
		var tds = tr.cells;
		for(var i = 0; i < tds.length; i++){
			
			tds[i].style.color = "white";
		}
	}
}

//当鼠标离开时，恢复原始样式
function clearBGColor(){
	
	if(event && event.srcElement && event.srcElement.tagName == "TD"){
		
		var td = event.srcElement;
		var tr = td.parentElement;
		tr.style.backgroundColor = "transparent";//透明色
		
		var tds = tr.cells;
		for(var i = 0; i < tds.length; i++){
			tds[i].style.color = "darkslategrey";
		}
	}
	
}

//当鼠标悬浮在单价单元格时，显示手势
function showHand(){
	if(event && event.srcElement && event.srcElement.tagName == "TD"){
		var td = event.srcElement;
		//cursor：光标
		td.style.cursor = "hand";
	}
}