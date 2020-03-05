package Soap;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class ReportGeneration {
	public void runner(String OutFolder)
	{
		try
		{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String formattedDate = sdf.format(date);
		File file =new File(OutFolder+"\\Report_"+formattedDate+".html");
		file.createNewFile();
		this.PF();
		this.htmlheader(file);
		this.readFileScenario(file);
		this.readEachFile(file);
		this.htmlfooter(file);
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
	
	int i,j;
	public int count,tcount,pcount;
	int lineNum;
	public void htmlheader(File file)
	{
		try
		{
		////System.out.print("<html><head><meta http-equiv='content-type' content='text/html; charset=UTF-8'><meta name='robots' content='noindex, nofollow'>  <meta name='googlebot' content='noindex, nofollow'>  <script type='text/javascript' src='/js/lib/dummy.js'></script>  <link rel='stylesheet' type='text/css' href='/css/result-light.css'>  <link rel='stylesheet' type='text/css' href='http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css'>  <style type='text/css'>    .ui-tabs.ui-tabs-vertical {    padding: 0;    width: 70em;}.ui-tabs.ui-tabs-vertical .ui-widget-header {    border: none;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav {    float: left;    width: 10em;    background: #CCC;    border-radius: 4px 0 0 4px;    border-right: 1px solid gray;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li {    clear: left;    width: 100%;    margin: 0.2em 0;    border: 1px solid gray;    border-width: 1px 0 1px 1px;    border-radius: 4px 0 0 4px;    overflow: hidden;    position: relative;    right: -2px;    z-index: 2;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li a {    display: block;    width: 100%;    padding: 0.6em 1em;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li a:hover {    cursor: pointer;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active {    margin-bottom: 0.2em;    padding-bottom: 0;    border-right: 1px solid white;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li:last-child {    margin-bottom: 10px;}.ui-tabs.ui-tabs-vertical .ui-tabs-panel {    float: left;    width: 28em;    border-left: 1px solid gray;    border-radius: 0;    position: relative;    left: -1px;}</style><script type='text/javascript'>window.onload=function(){$('#tabs')    .tabs()    .addClass('ui-tabs-vertical ui-helper-clearfix');}</script></head><body style='padding: 5px;'>  <script src='http://code.jquery.com/jquery-1.8.2.js'></script><script src='http://code.jquery.com/ui/1.9.1/jquery-ui.js'></script>   <div class='ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix'><table><b><tr style='color:green'><td><b>Pass</b></td><td><b>=</b></td><td><b>"+tcount+"</b></td></tr><tr style='color:red'><td><b>Fail</b></td><td><b>=</b></td><td><b>"+count+"</b></td></tr></b></table></div>      <div id='tabs' class='ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix'>");
		String d = "<html><head><meta http-equiv='content-type' content='text/html; charset=UTF-8'><meta name='robots' content='noindex, nofollow'>  <meta name='googlebot' content='noindex, nofollow'>  <script type='text/javascript' src='/js/lib/dummy.js'></script>  <link rel='stylesheet' type='text/css' href='/css/result-light.css'>  <link rel='stylesheet' type='text/css' href='http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css'>  <style type='text/css'>    .ui-tabs.ui-tabs-vertical {    padding: 0;    width: 70em;}.ui-tabs.ui-tabs-vertical .ui-widget-header {    border: none;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav {    float: left;    width: 10em;    background: #CCC;    border-radius: 4px 0 0 4px;    border-right: 1px solid gray;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li {    clear: left;    width: 100%;    margin: 0.2em 0;    border: 1px solid gray;    border-width: 1px 0 1px 1px;    border-radius: 4px 0 0 4px;    overflow: hidden;    position: relative;    right: -2px;    z-index: 2;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li a {    display: block;    width: 100%;    padding: 0.6em 1em;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li a:hover {    cursor: pointer;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active {    margin-bottom: 0.2em;    padding-bottom: 0;    border-right: 1px solid white;}.ui-tabs.ui-tabs-vertical .ui-tabs-nav li:last-child {    margin-bottom: 10px;}.ui-tabs.ui-tabs-vertical .ui-tabs-panel {    float: left;    width: 28em;    border-left: 1px solid gray;    border-radius: 0;    position: relative;    left: -1px;}</style><script type='text/javascript'>window.onload=function(){$('#tabs')    .tabs()    .addClass('ui-tabs-vertical ui-helper-clearfix');}</script></head><body style='padding: 5px;'>  <script src='http://code.jquery.com/jquery-1.8.2.js'></script><script src='http://code.jquery.com/ui/1.9.1/jquery-ui.js'></script>   <div class='ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix'><table align='center'><tr><td><table><b><tr style='color:blue'><td><b>Total</b></td><td><b>=</b></td><td><b>"+pcount+"</b></td></tr><b><tr style='color:green'><td><b>Pass</b></td><td><b>=</b></td><td><b>"+tcount+"</b></td></tr><tr style='color:red'><td><b>Fail</b></td><td><b>=</b></td><td><b>"+count+"</b></td></tr></b></table></td><td></td><td></td><td></td><td></td><td><div id='piechart' style='width: 250px; height: 250px;'></div></td></tr></table></div>      <div id='tabs' class='ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix'>";
		this.htmlCreation(file, d);  
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
	
	public void readFileScenario(File file)
 {
		try
		{
		this.ulstart(file);
				
		String fileName = "D:\\Reports\\Scenarios.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			int v=1;
			String classli="ui-state-default ui-corner-top ui-tabs-active ui-state-active";
			String tabindex="0";
			String labelledby="ui-id-";
			String selected = "True";
			
			while ((line = br.readLine()) != null) {
				if (v==1)
				{
				  ////System.out.println("<li class='"+classli+"' role='tab' tabindex='"+tabindex+"' aria-controls='a"+v+"' aria-labelledby='"+labelledby+""+v+"' aria-selected='"+selected+"'><a href='#a"+v+"' class='ui-tabs-anchor' role='presentation' tabindex='-1' id='"+labelledby+""+v+"'>"+line+"</a></li>");
				  String d = "<li class='"+classli+"' role='tab' tabindex='"+tabindex+"' aria-controls='a"+v+"' aria-labelledby='"+labelledby+""+v+"' aria-selected='"+selected+"'><a href='#a"+v+"' class='ui-tabs-anchor' role='presentation' tabindex='-1' id='"+labelledby+""+v+"'>"+line+"</a></li>";
				  this.htmlCreation(file, d); 
				}
				else
				{
					////System.out.println("<li class='ui-state-default ui-corner-top' role='tab' tabindex='-1' aria-controls='a"+v+"' aria-labelledby='"+labelledby+""+v+"' aria-selected='false'><a href='#a"+v+"' class='ui-tabs-anchor' role='presentation' tabindex='-1' id='"+labelledby+""+v+"'>"+line+"</a></li>");
					String d = "<li class='ui-state-default ui-corner-top' role='tab' tabindex='-1' aria-controls='a"+v+"' aria-labelledby='"+labelledby+""+v+"' aria-selected='false'><a href='#a"+v+"' class='ui-tabs-anchor' role='presentation' tabindex='-1' id='"+labelledby+""+v+"'>"+line+"</a></li>";
					this.htmlCreation(file, d); 
				}
				v++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.ulend(file);
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
	
	
	public void readEachFile(File file)
	{
		try
		{
		String fileFolder = "D:\\Reports\\Scenarios";
		File f = new File(fileFolder);
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
		
		for(i=0;i<names.size();i++)
		{
			this.divstart(i,file);
			//////System.out.print("******************************"+names.get(i));
			String FileNameR = names.get(i).toString();
			try (BufferedReader br = new BufferedReader(new FileReader(fileFolder+"\\"+FileNameR))) {

				String line;
				int l=0;
				while ((line = br.readLine()) != null) {
					////System.out.println(line);
					List<String> data = Arrays.asList(line.split(","));
					
					//System.out.println("<tr>");
					String d ="<tr>"; 
					this.htmlCreation(file, d); 
					for(j=0;j<data.size();j++)
					{
						if(l==0)
						{
						////System.out.print("==============="+data.get(j));
						//System.out.println("<th>"+data.get(j)+"</th>");
						String d1 ="<th>"+data.get(j)+"</th>"; 
						this.htmlCreation(file, d1); 
						}
						else
						{
							////System.out.print("-----------------------"+data.get(j).toString());
							if((data.get(j).toString()).contains("Fail"))
							{
								//System.out.println("<td style='color:red'>"+data.get(j)+"</td>");
								String d2 = "<td style='color:red'>"+data.get(j)+"</td>";
										this.htmlCreation(file, d2);
							}
							else if((data.get(j).toString()).contains("Pass"))
							{
								//System.out.println("<td style='color:green'>"+data.get(j)+"</td>");
								String d3 = "<td style='color:green'>"+data.get(j)+"</td>";
										this.htmlCreation(file, d3);
							}
							else
							{
								//System.out.println("<td>"+data.get(j)+"</td>");
								String d4 = "<td>"+data.get(j)+"</td>";
										this.htmlCreation(file, d4);
							}
						}
						
					}
					//System.out.println("</tr>");	
					String d5 = "</tr>";
					this.htmlCreation(file, d5);
					l++;
				}
				

			} catch (IOException e) {
				e.printStackTrace();
			}
			this.divend(file);
		}
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
		
	}
	
	public void htmlfooter(File file)
	{
		try
		{
		//System.out.print("</div></body></html>");
		String d ="</div></body><script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script><script type='text/javascript'>google.charts.load('current', {'packages':['corechart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Scenario', 'Total Scenario'],['null',     0],['FAIL',     "+count+"],['null',     0],['PASS',     "+tcount+"]]);var options = {title: 'Test Case Result'};var chart = new google.visualization.PieChart(document.getElementById('piechart'));chart.draw(data, options);}</script></html>"; 
				this.htmlCreation(file, d);
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
	
	public void ulstart(File file)
	{
		try
		{
		//System.out.print("<ul class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all' role='tablist'>");
		String d = "<ul class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all' role='tablist'>";
				this.htmlCreation(file, d);
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
	public void ulend(File file)
	{
		try
		{
		//System.out.print("</ul>");
		String d = "</ul>";
				this.htmlCreation(file, d);
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
	
	public void divstart(int i,File file)
	{
		try
		{
		int j=i+1;
		if (j==1)
		{
		//System.out.print("<div id='a"+j+"' aria-labelledby='ui-id-"+j+"' class='ui-tabs-panel ui-widget-content ui-corner-bottom' role='tabpanel' aria-expanded='true' aria-hidden='false' style='display: block;'><table border='solid' width='100%'>");
		String d = "<div id='a"+j+"' aria-labelledby='ui-id-"+j+"' class='ui-tabs-panel ui-widget-content ui-corner-bottom' role='tabpanel' aria-expanded='true' aria-hidden='false' style='display: block;'><table border='solid' width='100%'>";
				this.htmlCreation(file, d);
		}
		else
		{
			//System.out.print("<div id='a"+j+"' aria-labelledby='ui-id-"+j+"' class='ui-tabs-panel ui-widget-content ui-corner-bottom' role='tabpanel' aria-expanded='false' aria-hidden='true' style='display: none;'><table border='solid' width='100%'>");
			String d = "<div id='a"+j+"' aria-labelledby='ui-id-"+j+"' class='ui-tabs-panel ui-widget-content ui-corner-bottom' role='tabpanel' aria-expanded='false' aria-hidden='true' style='display: none;'><table border='solid' width='100%'>";
					this.htmlCreation(file, d);
		}
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
	
	public void divend(File file)
	{
		try
		{
		//System.out.print("</table></div>");
		String d = "</table></div>";
				this.htmlCreation(file, d);
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
	
	
	public void PF()
	{
		try
		{
		count=0;
		String fileFolder = "D:\\Reports\\Scenarios";
		File f = new File(fileFolder);
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
		
		for(i=0;i<names.size();i++)
		{
			String FileNameR = names.get(i).toString();
			File file = new File(fileFolder+"\\"+FileNameR);
			Scanner scanner = new Scanner(file);
			lineNum = 0;
		    while (scanner.hasNextLine()) {
		    	String line = scanner.nextLine();
		    	lineNum++;
		        if(line.contains("Fail") || line.contains("Failed") || line.contains("failed") || line.contains("fail")) { 
		        count++;   
		        break;
		        }
		        else
		        {
		        	count=count+0;
		        }
		    }
		    scanner.close();
		}
		pcount=names.size();
		tcount = pcount-count;
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
				
	}
	
	public void htmlCreation(File file, String data)
	{
		try
		{
		FileWriter fw = new FileWriter(file,true);
		fw.write(data);
		fw.close();
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}

}
