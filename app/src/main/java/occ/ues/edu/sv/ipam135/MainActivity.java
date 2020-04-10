package occ.ues.edu.sv.ipam135;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText _display;
    private String textDisplay="";
    int contador=0;
    private EditText resultado;
    private double resul=0;
    Boolean onOff=true;
    private ImageButton [] botones= new ImageButton[20];
    char root = '\u221A';
    private List<String> contenido = new ArrayList<>();
    List<String> listaOperaciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _display = (EditText)findViewById(R.id.display);
        resultado= (EditText)findViewById(R.id.txtRESULT);


        //necesario para habilitar/inhabilita botones. :c

        botones[0]=(ImageButton)findViewById(R.id.btnCERO);
        botones[1]=(ImageButton)findViewById(R.id.btnUNO);
        botones[2]=(ImageButton)findViewById(R.id.btnDOS);
        botones[3]=(ImageButton)findViewById(R.id.btnTRES);
        botones[4]=(ImageButton)findViewById(R.id.btnCUATRO);
        botones[5]=(ImageButton)findViewById(R.id.btnCINCO);
        botones[6]=(ImageButton)findViewById(R.id.btnSEIS);
        botones[7]=(ImageButton)findViewById(R.id.btnSIETE);
        botones[8]=(ImageButton)findViewById(R.id.btnOCHO);
        botones[9]=(ImageButton)findViewById(R.id.btnNUEVE);
        botones[10]=(ImageButton)findViewById(R.id.btnMAS);
        botones[11]=(ImageButton)findViewById(R.id.btnMENOS);
        botones[12]=(ImageButton)findViewById(R.id.btnDIV);
        botones[13]=(ImageButton)findViewById(R.id.btnX);
        botones[14]=(ImageButton)findViewById(R.id.btnDOT);
        botones[15]=(ImageButton)findViewById(R.id.btnIGUAL);
        botones[16]=(ImageButton)findViewById(R.id.btnDEL);
        botones[17]=(ImageButton)findViewById(R.id.btnPOTENCIA);
        botones[18]=(ImageButton)findViewById(R.id.btnCLEAR);
        botones[19]=(ImageButton)findViewById(R.id.btnRAIZ);
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);
        }
    }

    public void clickKey(View v){
        if(textDisplay=="sintax Error"){
            textDisplay="";
        }
        switch (v.getId()){
            case R.id.btnCERO:
                textDisplay=textDisplay+0;
                contenido.add("0");
                break;
            case R.id.btnUNO:
                textDisplay=textDisplay+1;
                contenido.add("1");
                break;
            case R.id.btnDOS:
                textDisplay=textDisplay+2;
                contenido.add("2");
                break;
            case R.id.btnTRES:
                textDisplay=textDisplay+3;
                contenido.add("3");
                break;
            case R.id.btnCUATRO:
                textDisplay=textDisplay+4;
                contenido.add("4");
                break;
            case R.id.btnCINCO:
                textDisplay=textDisplay+5;
                contenido.add("5");
                break;
            case R.id.btnSEIS:
                textDisplay=textDisplay+6;
                contenido.add("6");
                break;
            case R.id.btnSIETE:
                textDisplay=textDisplay+7;
                contenido.add("7");
                break;
            case R.id.btnOCHO:
                textDisplay=textDisplay+8;
                contenido.add("8");
                break;
            case R.id.btnNUEVE:
                textDisplay=textDisplay+9;
                contenido.add("9");
                break;
            case R.id.btnMAS:
                if(resul!=0){
                    textDisplay=resul+"";
                }
                if(verificarFormato()==true){
                    igual();
                }
                textDisplay=textDisplay+"+";
                contenido.add("+");

                break;
            case R.id.btnMENOS:
                if(resul!=0){
                    textDisplay=resul+"";
                }
                if(verificarFormato()==true){
                    igual();
                }
                textDisplay=textDisplay+"-";
                contenido.add("-");
                break;
            case R.id.btnDIV:
                if(resul!=0){
                    textDisplay=resul+"";
                }
                if(verificarFormato()==true){
                    igual();
                }
                textDisplay=textDisplay+"/";
                contenido.add("/");
                break;
            case R.id.btnX:
                if(resul!=0){
                    textDisplay=resul+"";
                }
                if(verificarFormato()==true){
                    igual();
                }
                textDisplay=textDisplay+"x";
                contenido.add("*");
                break;
            case R.id.btnDOT:
                textDisplay=textDisplay+".";
                contenido.add(".");
                break;
            case R.id.btnPOTENCIA:
                if(resul!=0){
                    textDisplay=resul+"";
                }
                if(verificarFormato()==true){
                    igual();
                }
                textDisplay=textDisplay+"^";
                contenido.add("^");
                break;
            case R.id.btnIGUAL:
               igual();
                break;
            case R.id.btnCLEAR:
                textDisplay="";
                contenido = new ArrayList<>();
                break;
            case R.id.btnRAIZ:
                textDisplay=textDisplay+root;
                contenido.add(root+"");
                igualRaiz();
                break;
            case R.id.btnDEL:
                if(textDisplay.length()>0){
                    textDisplay=textDisplay.substring(0, textDisplay.length()-1);
                }
                if(contenido.size()>0){
                    contenido.remove(contenido.size()-1);
                }
                break;
        }
        _display.setText(textDisplay);
    }

    /**
     * ordena el array y almacena un caracter en cada posicion
     * @return array con un elemento en cada posicion.
     */
    public List sortArray(){
        List<String> array= new ArrayList<>();
        String valores="";
        array.add("0");
        for (int i=0;i<contenido.size();i++){
            if(contenido.get(i).matches("[-+^*/√]")){
                if(!valores.isEmpty() || !valores.equals("")){
                    array.add(valores);
                }
                array.add(contenido.get(i));
                valores="";
            }else if(contenido.get(i).matches("[0-9]") ){
                valores=valores+contenido.get(i);
            }else if(contenido.get(i).matches("[.]")){
                valores=valores+contenido.get(i);
            }
        }
        if(!valores.isEmpty() || !valores.equals("")){
            array.add(valores);
        }
        return array;
    }

    public void validarSize(){
        for (int i = 0; i < textDisplay.length(); i++) {

            if(textDisplay.charAt(i)=='-' || textDisplay.charAt(i)=='+'){
                contador=contador+1;
            }
        }

    }

    public boolean verificarFormato(){
        listaOperaciones=sortArray();
        int val =0;
        for (int i = 0; i <listaOperaciones.size() ; i++) {
            if(listaOperaciones.get(i).matches("[-+*/^]")){
                val=val+1;
            }
        }

        if(val==1 && listaOperaciones.size()==4){
            return true;
        }else if (val==2 && listaOperaciones.size()==5){
            return true;
        }else if(val==3 && listaOperaciones.size()==6){
            return true;
        }
        return false;
    }

    public void igualRaiz(){
        List<String> listaOperaciones=sortArray();
        if(listaOperaciones.get(2).matches("[√]")){
            resul=Math.sqrt(Double.parseDouble(listaOperaciones.get(1)));
        }else if (listaOperaciones.size()>3){
            textDisplay="sintax Error";
        }

        resultado.setText(resul+"");
        contenido= new ArrayList<>();
        String aux= resul+"";
        for (int i = 0; i <aux.length() ; i++) {
            contenido.add(aux.charAt(i)+"");
        }
        resul=0;
    }

    /**
     * realiza la operacion requerida
     */
    public void igual(){
      listaOperaciones=sortArray();
        if (listaOperaciones.get(1).matches("[+/*^.]")) {
            textDisplay = "sintax Error";
        }else if(listaOperaciones.get(1).matches("[-√]")){
        }
        else{
            resul=Double.parseDouble(listaOperaciones.get(1));
        }
        for (int i = 1; i < listaOperaciones.size(); i++) {
            if(listaOperaciones.get(i-1).matches("[-√+/*^]")){
                switch (listaOperaciones.get(i-1)){
                    case "+":
                        if(listaOperaciones.get(i).equals("-")){
                            resul=resul+-Double.parseDouble(listaOperaciones.get(i+1));
                            i=i+1;
                        }
                        else if(listaOperaciones.get(i).matches("[√+/*^]")){
                            textDisplay="sintax Error";
                        }else {
                            resul = resul + Double.parseDouble(listaOperaciones.get(i));
                        }
                        break;
                    case "-":
                        if(listaOperaciones.get(i).equals("-")){
                            resul=resul+Double.parseDouble(listaOperaciones.get(i+1));
                            i=i+1;
                        }
                        else if(listaOperaciones.get(i).matches("[√+/*^]")){
                            textDisplay="sintax Error";
                        }else {
                            resul = resul - Double.parseDouble(listaOperaciones.get(i));
                        }
                        break;
                    case "*":
                        if(listaOperaciones.get(i).equals("-")){
                            resul=resul*-Double.parseDouble(listaOperaciones.get(i+1));
                            i=i+1;
                        }
                        else if(listaOperaciones.get(i).matches("[√+/*^]")){
                            textDisplay="sintax Error";
                        }
                        else{
                            resul=resul*Double.parseDouble(listaOperaciones.get(i));
                        }
                        break;
                    case "/":

                        if(listaOperaciones.get(i).equals("-")){
                            if(listaOperaciones.get(i+1).equals("0") || listaOperaciones.get(i+1).equals("0.0") ){
                            textDisplay="sintax Error";
                        }
                            resul=resul/-Double.parseDouble(listaOperaciones.get(i+1));
                            i=i+1;
                        }else if(listaOperaciones.get(i).matches("[√+/*^]")){
                            textDisplay="sintax Error";
                        }
                        else {
                            if(listaOperaciones.get(i).equals("0") || listaOperaciones.get(i).equals("0.0")){
                                textDisplay="sintax Error";
                            }
                            resul = resul/Double.parseDouble(listaOperaciones.get(i));
                        }
                        break;
                    case "^":
                        if(listaOperaciones.get(i).equals("-")){
                            resul=Math.pow(resul,-Double.parseDouble(listaOperaciones.get(i+1)));
                            i=i+1;
                        }else if(listaOperaciones.get(i).matches("[√+/*^]")){
                            textDisplay="sintax Error";
                        }else{
                            resul=Math.pow(resul,Double.parseDouble(listaOperaciones.get(i)));
                        }
                        break;
                        //TODO: el btn debe de ser presionado antes o despues del valor númerico?
             /*       case "√":
                        if (listaOperaciones.get(i).equals("-")){
                            resultado.setText("sintax Error");
                        }else{
                            resul=Math.sqrt(Double.parseDouble(listaOperaciones.get(i)));
                        }
                        break;
                        */
                }
            }
        }
        resultado.setText(resul+"");
        contenido= new ArrayList<>();
        String aux= resul+"";
        for (int i = 0; i <aux.length() ; i++) {
            contenido.add(aux.charAt(i)+"");
        }
        resul=0;
    }

    /**
     * Desabilitar o habilitar los botones
     * @param v
     */
    public void enableBtn(View v){
        if(onOff==true){
            for (int i = 0; i < botones.length; i++) {
                botones[i].setEnabled(true);
            }
            onOff=false;
        }else {
            for (int i = 0; i < botones.length; i++) {
                botones[i].setEnabled(false);
            }
            onOff=true;
        }
        textDisplay="";
        resultado.setText("");
        _display.setText("");
    }


}
