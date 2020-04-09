package occ.ues.edu.sv.ipam135;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText _display;
    private String textDisplay="";
    private EditText resultado;
    private double resul=0;
    char root = '\u221A';
    private List<String> contenido = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _display = (EditText)findViewById(R.id.display);
        resultado= (EditText)findViewById(R.id.txtRESULT);

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
                textDisplay=textDisplay+"+";
                contenido.add("+");
                break;
            case R.id.btnMENOS:
                textDisplay=textDisplay+"-";
                contenido.add("-");
                break;
            case R.id.btnDIV:
                textDisplay=textDisplay+"/";
                contenido.add("/");
                break;
            case R.id.btnX:
                textDisplay=textDisplay+"x";
                contenido.add("*");
                break;
            case R.id.btnDOT:
                textDisplay=textDisplay+".";
                contenido.add(".");
                break;
            case R.id.btnPOTENCIA:
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

    public void igual(){
        List<String> listaOperaciones=sortArray();

        if (listaOperaciones.get(1).matches("[+/*^.]")) {
            textDisplay = "sintax Error";
        }else if(listaOperaciones.get(1).matches("[-√]")){
        }
        else{
            resul=Double.valueOf(listaOperaciones.get(1));
        }
        for (int i = 1; i < listaOperaciones.size(); i++) {
            if(listaOperaciones.get(i-1).matches("[-√+/*^]")){
                switch (listaOperaciones.get(i-1)){
                    case "+":
                        resul=resul+Double.parseDouble(listaOperaciones.get(i));
                        break;
                    case "-":
                        resul=resul-Double.parseDouble(listaOperaciones.get(i));
                        break;
                    case "*":
                        resul=resul*Double.parseDouble(listaOperaciones.get(i));
                        break;
                    case "/":
                        resul=resul/Double.parseDouble(listaOperaciones.get(i));
                        break;
                    case "^":
                        resul=Math.pow(resul,Double.parseDouble(listaOperaciones.get(i)));
                        break;
                        //TODO:(ver video y resolver dudas)
                    case "√":
                        resul=Math.sqrt(Double.parseDouble(listaOperaciones.get(i)));
                        break;
                }
            }
        }
        resultado.setText(resul+"");
        contenido= new ArrayList<>();
        contenido.add(resul+"");
        resul=0;
    }



}
