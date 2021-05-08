/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youtubeDlGui.app.controller;

import com.youtubeDlGui.app.model.Observer;
import com.youtubeDlGui.app.model.YoutubeDl;
import com.youtubeDlGui.app.view.ViewYoutubeDl;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class ControllerViewYoutubeDl implements Observer {
    
    private YoutubeDl model;
    private ViewYoutubeDl view;

    public ControllerViewYoutubeDl(YoutubeDl model, ViewYoutubeDl view) {
       this.model=model;
       this.view=view;
       this.model.attach(this);
    }
    
    

    @Override
    public void update() {
       
    }

    public void trataBotao(ActionEvent evt) {
        
        if( "Download".equals(evt.getActionCommand())){
             
            this.getModel().setUrl(this.view.getjText_url().getText());
            
             if (this.getView().getjRadioQualidade().isSelected()){
                 System.out.println("Na melhor qualidade");
                this.getModel().setQualidade(" -f best ");
                        
            }
            if (this.getView().getjRadioSelecionarQualidade().isSelected()){
                System.out.println("Selecionar qualidade ");
                String qualidade;
                qualidade=JOptionPane.showInputDialog( this.getModel().selecionarQualidade());
                this.getModel().setQualidade(" -f "+qualidade);
                    
            }
            
            if (this.getView().getjRadioApenasAudio().isSelected()){
                System.out.println("Apenas audio-youtube");
                 this.getModel().setQualidade(" -f 140");
            }
            
       //  this.getModel().obterTitulo();
           this.getModel().obterThumb();
           //this.getModel().iniciarBaixar();
             
        }
        
    }

    public YoutubeDl getModel() {
        return model;
    }

    public ViewYoutubeDl getView() {
        return view;
    }
    
}
