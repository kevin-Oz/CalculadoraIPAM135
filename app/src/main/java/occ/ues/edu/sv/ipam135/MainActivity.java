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
    char a = '\u221A';
    private List<String> contenido = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _display = (EditText)findViewById(R.id.display);
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
                break;
            case R.id.btnCLEAR:
                textDisplay="";
                contenido = new ArrayList<>();
                break;
            case R.id.btnRAIZ:
                textDisplay=textDisplay+ a;
                contenido.add(a+"");
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



}
