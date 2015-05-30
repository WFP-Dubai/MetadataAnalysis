package meta;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetMeta {

  public String getAllMeta(){
    String strLine;
    String[] heading;
    String headingTester;
    String headingTester2 = "";
    int i = 0;
    int j = 0;
    final String[][] outputline = new String[1000][1000];

    try {
      final FileInputStream fstream = new FileInputStream("C:\\Users\\mark.uygur\\Desktop\\temp\\metadata.properties");
      //final FileInputStream fstream = new FileInputStream("/opt/sti/SIServer/webapps/SIServer/WEB-INF/classes/properties/metadata.properties");
      //final FileInputStream fstream = new FileInputStream("/home/ukram123/public_html/MetadataAnalysis/metadata.properties");

      final BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      while ((strLine = br.readLine()) != null)   {
        if (strLine.matches(".*\\..*=.*")){

          System.out.println(strLine);
          heading = strLine.split("\\.");
          headingTester = heading[0] + "."+ heading[1];
          if (headingTester.equals(headingTester2)){
            outputline[i][j] = strLine;
            j++;
          } else {
            if ((i==0) & headingTester2.equals("")){
              j=0;
              outputline[i][j] = strLine;
              j++;
            } else {
              i++;
              j=0;
              outputline[i][j] = strLine;
              j++;
            }
          }
          headingTester2=headingTester;
        }
      }

      System.out.println();
      System.out.println();

      br.close();
      return inputIntoFile(outputline);

    } catch (final IOException e) {
        e.printStackTrace();
    }

    return "";

  }

  public static String inputIntoFile(final String ouputLine[][]) throws IOException{

    String stringToOutputHTML = "";
   // final String stringToOutputCSV = "";

    for(int i=0;i<50;i++){

        if (ouputLine[i][0] != null ) {
          if (!ouputLine[i][0].matches("nepal\\.municipalities.*") && !ouputLine[i][0].matches("nepal\\.displacementsites.*")
              && !ouputLine[i][0].matches("nepal\\.idpcamps.*") && !ouputLine[i][0].matches("nepal\\.preliminarydamage.*")){


        //    stringToOutputCSV = stringToOutputCSV + "\"" + getLayerCategory(ouputLine[i]) + "\"";
        //    stringToOutputCSV = stringToOutputCSV + ",\"" +  getLayer(ouputLine[i]) + "\"";
        //    stringToOutputCSV = stringToOutputCSV + ",\"" +  getDescription(ouputLine[i]) + "\"";
        //    stringToOutputCSV = stringToOutputCSV + ",\"" +   getDataSources(ouputLine[i]) + "\"";
        //    stringToOutputCSV = stringToOutputCSV + ",\"" +  getDataOwner(ouputLine[i]) + "\"";
         //   stringToOutputCSV = stringToOutputCSV + ",\"" + getLayerAuthor(ouputLine[i]) + "\"";
          //  stringToOutputCSV = stringToOutputCSV + ",\"" +   getLayerCreationDate(ouputLine[i]) + "\"";
          //  stringToOutputCSV = stringToOutputCSV + ",\"" +  getLayerModificationAuthor(ouputLine[i]) + "\"";
          //  stringToOutputCSV = stringToOutputCSV + ",\"" +   getLayerModificationDate(ouputLine[i]) + "\"";
        //    System.out.println("here is the final string: " +stringToOutputCSV);
        //    stringToOutputCSV = "";

            stringToOutputHTML = stringToOutputHTML + "<tr>";
            stringToOutputHTML = stringToOutputHTML + "<td>" + getLayerCategory(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "<td>" +  getLayer(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "<td id='description'>" + getDescription(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "<td>" +   getDataSources(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "<td id='owner'>" +  getDataOwner(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "<td>" + getLayerAuthor(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "<td>" +   getLayerCreationDate(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "<td>" +  getLayerModificationAuthor(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "<td>" +   getLayerModificationDate(ouputLine[i]) + "</td>";
       //     stringToOutputHTML = stringToOutputHTML + "<td>" +   getGlossary(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "<td>" +   getChangeLogs(ouputLine[i]) + "</td>";
            stringToOutputHTML = stringToOutputHTML + "</tr>";
          }
        }

    }

    return stringToOutputHTML;

  }

  public static String getLayerCategory(final String outputLine[]) throws IOException{

    String layerCategory[];

    layerCategory = outputLine[0].split("\\.");

    if (layerCategory[0].matches("tracking")) {

      layerCategory[0] = "mobile assets";
    }

    if (layerCategory[0].matches("telecommunications")) {
      layerCategory[0] = "fixed assets";
    }

    if (layerCategory[0].matches("gdacs")) {
      layerCategory[0] = "events";
    }

    if (layerCategory[0].matches("locations")) {
      layerCategory[0] = "fixed assets";
    }

    if (layerCategory[0].matches("nepal") && layerCategory[1].matches("adminboundarieslevel1")) {
      layerCategory[0] = "basemaps";
    }
    if (layerCategory[0].matches("nepal") && layerCategory[1].matches("adminboundarieslevel2")) {
      layerCategory[0] = "basemaps";
    }
    if (layerCategory[0].matches("nepal") && layerCategory[1].matches("adminboundarieslevel3")) {
      layerCategory[0] = "basemaps";
    }
    if (layerCategory[0].matches("nepal") && layerCategory[1].matches("impassableroads")) {
      layerCategory[0] = "basemaps";
    }
    if (layerCategory[0].matches("nepal") && layerCategory[1].matches("rivers")) {
      layerCategory[0] = "basemaps";
    }

    return layerCategory[0];


  }

  public static String getLayer(final String outputLine[]) throws IOException{

    String layer[];

    layer = outputLine[0].split("\\.");

    if (layer[1].matches("adminboundarieslevel1")) {

      layer[1] = "admin regions";
    }

    if (layer[1].matches("adminboundarieslevel2")) {

      layer[1] = "admin zones";
    }

    if (layer[1].matches("adminboundarieslevel3")) {

      layer[1] = "admin districts";
    }
    return layer[1];


  }


  public static String getDescription(final String outputLine[]) throws IOException{

    String description[] = new String[50];

    for(int j=0;j<40;j++){
      if (outputLine[j] != null){
        if  (outputLine[j].matches(".*\\.description.*")){
          description = outputLine[j].split("=");
          break;
        }
      }
    }
   // System.out.println("here is the description: " + description[1]);
    return description[1];
  }


  public static String getDataSources(final String outputLine[]) throws IOException{

    String description[] = new String[50];
    String dataSource = "";
    int loopTracker = 0;
    int loopTracker2 = 0;

    for(int j=0;j<25;j++){
      if (outputLine[j] != null){
        if  (outputLine[j].matches(".*\\.dataSources.*")){
          description = outputLine[j].split("dataSources=");
          dataSource = dataSource +  " " + description[1] + "<br><br>";
          loopTracker++;
        }

        if  (outputLine[j].matches(".*\\.middleware\\.dataSourceAndUpdateFrequency.*")){
          description = outputLine[j].split("=");
          dataSource = dataSource +  " " + "<strong>The following report to the middleware:</strong>" + "<br><br>" + description[1] + "<br><br>";
          loopTracker++;
        }
        if (loopTracker == 2) {break;}
      }
    }

    for(int j=0;j<40;j++){
      if (outputLine[j] != null){
        if (outputLine[j].matches(".*\\.dataSourceAndUpdateFrequencyLDAP.*")){
          description = outputLine[j].split("=");
          dataSource = dataSource + " " + "<strong>Update Frequency:</strong>" + "<br><br>" + description[1] + "/ Last Run 10 minutes ago" + "<br><br>";
          loopTracker2++;
        }

        if (outputLine[j].matches(".*\\.dataSourceAndUpdateFrequencyMiddleware.*")){
          description = outputLine[j].split("=");
          dataSource = dataSource +  " " + description[1]  + "/ Last Run 10 minutes ago" + "<br>";
          loopTracker2++;
        }
        if (loopTracker2 == 2) {break;}
      }
    }

   // System.out.println("here is the combined data sources: " + dataSource);
    return dataSource;

  }


  public static String getDataOwner(final String outputLine[]) throws IOException{

    String description[] = new String[50];

    for(int j=0;j<40;j++){
      if (outputLine[j] != null){
        if  (outputLine[j].matches(".*\\.dataOwner.*")){
          description = outputLine[j].split("=");
          break;
        }
      }
    }
   // System.out.println("here is the dataOwner: " + description[1]);
    return description[1];

  }

  public static String getLayerAuthor(final String outputLine[]) throws IOException{

    String description[] = new String[50];

    for(int j=0;j<40;j++){
      if (outputLine[j] != null){
        if  (outputLine[j].matches(".*\\.layerAuthor.*")){
          description = outputLine[j].split("=");
          break;
        }
      }
    }
   // System.out.println("here is the layerAuthor: " + description[1]);

    return description[1];
  }

  public static String getLayerCreationDate(final String outputLine[]) throws IOException{

    String description[] = new String[50];

    for(int j=0;j<40;j++){
      if (outputLine[j] != null){
        if  (outputLine[j].matches(".*\\.layerCreationDate.*")){
          description = outputLine[j].split("=");
          break;
        }
      }
    }
   // System.out.println("here is the layerCreationDate: " + description[1]);
    return description[1];

  }


  public static String getLayerModificationAuthor(final String outputLine[]) throws IOException{

    String description[] = new String[50];

    for(int j=0;j<40;j++){
      if (outputLine[j] != null){
        if  (outputLine[j].matches(".*\\.layerModificationAuthor.*")){
          description = outputLine[j].split("=");
          break;
        }
      }
    }
   // System.out.println("here is the layerModificationAuthor: " + description[1]);
    return description[1];

  }


  public static String getLayerModificationDate(final String outputLine[]) throws IOException{

    String description[] = new String[50];

    for(int j=0;j<40;j++){
      if (outputLine[j] != null){
        if  (outputLine[j].matches(".*\\.layerModificationDate.*")){
          description = outputLine[j].split("=");
          break;
        }
      }
    }
    //System.out.println("here is the layerModificationDate: " + description[1]);
    return description[1];

  }

  public static String getGlossary(final String outputLine[]) throws IOException{

    String description[] = new String[50];

    for(int j=0;j<40;j++){
      if (outputLine[j] != null){
        if  (outputLine[j].matches(".*\\.glossary.*")){
          description = outputLine[j].split("=");

          break;
        }
      }
    }
   // System.out.println("here is the glossary: " + description[1]);
    description[1] =  description[1].replace("|", "<br/><br/>");
    System.out.println("here is the glossary: " + description[1]);

    return description[1];

  }

  public static String getChangeLogs(final String outputLine[]) throws IOException{

    String description[] = new String[50];

    for(int j=0;j<40;j++){
      if (outputLine[j] != null){
        if  (outputLine[j].matches(".*\\.version.*")){
          description = outputLine[j].split("=");

          break;
        }
      }
    }
   // System.out.println("here is the glossary: " + description[1]);
    System.out.println("here is the glossary: " + description[1]);

    return description[1];

  }



}
