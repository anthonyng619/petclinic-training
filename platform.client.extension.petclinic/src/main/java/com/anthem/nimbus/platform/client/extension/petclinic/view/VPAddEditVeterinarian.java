package com.anthem.nimbus.platform.client.extension.petclinic.view;

import com.anthem.nimbus.platform.client.extension.petclinic.model.Veterinarian;
import com.anthem.oss.nimbus.core.domain.definition.Execution.Config;
import com.anthem.oss.nimbus.core.domain.definition.Executions.Configs;
import com.anthem.oss.nimbus.core.domain.definition.MapsTo;
import com.anthem.oss.nimbus.core.domain.definition.Model;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.Button;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.ButtonGroup;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.ComboBox;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.Form;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.Section;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.TextBox;
import com.anthem.oss.nimbus.core.domain.definition.ViewConfig.Tile;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rakesh Patel
 *
 */
@MapsTo.Type(Veterinarian.class)
@Getter @Setter
public class VPAddEditVeterinarian {
	
	@Tile(title="ADD/EDIT VETERINARIAN", imgSrc="resources/icons/autocase.svg#Layer_1", size=Tile.Size.Large) 
	private VTAddEditVeterinarian vtAddEditVeterinarian;
	
	
	@Model
	@Getter @Setter
	public static class VTAddEditVeterinarian {
		
		@Section
		private VSAddEditVeterinarian vsAddEditVeterinarian;
	}

	
	@MapsTo.Type(Veterinarian.class)
	@Getter @Setter
	public static class VSAddEditVeterinarian {
		
		@Form(cssClass="twoColumn")
		private VFAddEditVeterinarian vfAddEditVeterinarian;
	}
	
	
	@MapsTo.Type(Veterinarian.class)
	@Getter @Setter
	public static class VFAddEditVeterinarian {
		
		@ButtonGroup
		private VBGAddEditVeterinarian buttonGroup;
		
		@TextBox @MapsTo.Path
		private String firstName;
		
		@TextBox @MapsTo.Path
		private String lastName;
		
		@TextBox(hidden=true) @MapsTo.Path
		private String fullName;
		
		@ComboBox @MapsTo.Path 
		@Model.Param.Values(url="Anthem/icr/p/staticCodeValue/_search?fn=lookup&where=staticCodeValue.paramCode.eq('/vetSpecialty')")
		private String specialty;
	}
	
	
	@Model
	@Getter @Setter
	public static class VBGAddEditVeterinarian {
		
		@Config(url="/p/veterinarianlandingview/vpVeterenarians/vtVeterinarians/vsVeterinarians/_nav?pageId=vpVeterenarians")
		@Button
		private String cancel;
		
		@Configs({
			@Config(url="/vpAddEditVeterenarian/vtAddEditVeterinarian/vsAddEditVeterinarian/vfAddEditVeterinarian/_update"),
			@Config(url="/p/veterinarianlandingview/vpVeterenarians/vtVeterinarians/vsVeterinarians/_nav?pageId=vpVeterenarians")
		})
		@Button(style=Button.Style.PRIMARY, type = Button.Type.submit)
		private String Submit;
	}
}
