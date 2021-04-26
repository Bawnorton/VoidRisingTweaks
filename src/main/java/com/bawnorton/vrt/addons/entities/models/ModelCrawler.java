package com.bawnorton.vrt.addons.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrawler extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer ForeLeg1;
	private final ModelRenderer EndLeg1;
	private final ModelRenderer ForeLeg1_sub_1;
	private final ModelRenderer ForeLeg2;
	private final ModelRenderer EndLeg2;
	private final ModelRenderer ForeLeg2_sub_1;
	private final ModelRenderer ForeLeg3;
	private final ModelRenderer EndLeg3;
	private final ModelRenderer ForeLeg3_sub_1;
	private final ModelRenderer ForeLeg4;
	private final ModelRenderer EndLeg4;
	private final ModelRenderer ForeLeg4_sub_1;

	public ModelCrawler() {
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 17.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -4.0F, -2.0F, -4.0F, 8, 4, 8, 0.0F, false));

		ForeLeg1 = new ModelRenderer(this);
		ForeLeg1.setRotationPoint(4.0F, 16.0F, -3.0F);
		setRotationAngle(ForeLeg1, 0.0F, 0.0F, -0.5236F);
		ForeLeg1.cubeList.add(new ModelBox(ForeLeg1, 26, 18, 0.0F, -1.0F, -0.999F, 10, 2, 2, 0.0F, false));

		EndLeg1 = new ModelRenderer(this);
		EndLeg1.setRotationPoint(10.0F, 1.0F, 0.0F);
		ForeLeg1.addChild(EndLeg1);
		setRotationAngle(EndLeg1, 0.0F, 0.0F, -0.8727F);
		

		ForeLeg1_sub_1 = new ModelRenderer(this);
		ForeLeg1_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		EndLeg1.addChild(ForeLeg1_sub_1);
		ForeLeg1_sub_1.cubeList.add(new ModelBox(ForeLeg1_sub_1, 0, 20, -12.0F, -2.0F, -0.998F, 12, 2, 2, 0.0F, true));

		ForeLeg2 = new ModelRenderer(this);
		ForeLeg2.setRotationPoint(-4.0F, 16.0F, -3.0F);
		setRotationAngle(ForeLeg2, 0.0F, 0.0F, 0.5236F);
		ForeLeg2.cubeList.add(new ModelBox(ForeLeg2, 26, 14, -10.0F, -1.0F, -0.999F, 10, 2, 2, 0.0F, false));

		EndLeg2 = new ModelRenderer(this);
		EndLeg2.setRotationPoint(-10.0F, 1.0F, 0.0F);
		ForeLeg2.addChild(EndLeg2);
		setRotationAngle(EndLeg2, 0.0F, 0.0F, -2.2689F);
		

		ForeLeg2_sub_1 = new ModelRenderer(this);
		ForeLeg2_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		EndLeg2.addChild(ForeLeg2_sub_1);
		ForeLeg2_sub_1.cubeList.add(new ModelBox(ForeLeg2_sub_1, 0, 16, -12.0F, 0.0F, -0.998F, 12, 2, 2, 0.0F, true));

		ForeLeg3 = new ModelRenderer(this);
		ForeLeg3.setRotationPoint(-4.0F, 16.0F, 3.0F);
		setRotationAngle(ForeLeg3, 0.0F, 0.0F, 0.5236F);
		ForeLeg3.cubeList.add(new ModelBox(ForeLeg3, 24, 4, -10.0F, -1.0F, -1.001F, 10, 2, 2, 0.0F, false));

		EndLeg3 = new ModelRenderer(this);
		EndLeg3.setRotationPoint(-10.0F, 1.0F, 0.0F);
		ForeLeg3.addChild(EndLeg3);
		setRotationAngle(EndLeg3, 0.0F, 0.0F, -2.2689F);
		

		ForeLeg3_sub_1 = new ModelRenderer(this);
		ForeLeg3_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		EndLeg3.addChild(ForeLeg3_sub_1);
		ForeLeg3_sub_1.cubeList.add(new ModelBox(ForeLeg3_sub_1, 0, 12, -12.0F, 0.0F, -1.0F, 12, 2, 2, 0.0F, true));

		ForeLeg4 = new ModelRenderer(this);
		ForeLeg4.setRotationPoint(4.0F, 16.0F, 3.0F);
		setRotationAngle(ForeLeg4, 0.0F, 0.0F, -0.5236F);
		ForeLeg4.cubeList.add(new ModelBox(ForeLeg4, 24, 0, 0.0F, -1.0F, -1.001F, 10, 2, 2, 0.0F, false));

		EndLeg4 = new ModelRenderer(this);
		EndLeg4.setRotationPoint(10.0F, 1.0F, 0.0F);
		ForeLeg4.addChild(EndLeg4);
		setRotationAngle(EndLeg4, 0.0F, 0.0F, -0.8727F);
		

		ForeLeg4_sub_1 = new ModelRenderer(this);
		ForeLeg4_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		EndLeg4.addChild(ForeLeg4_sub_1);
		ForeLeg4_sub_1.cubeList.add(new ModelBox(ForeLeg4_sub_1, 0, 24, -12.0F, -2.0F, -1.0F, 12, 2, 2, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		ForeLeg1.render(f5);
		ForeLeg2.render(f5);
		ForeLeg3.render(f5);
		ForeLeg4.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}