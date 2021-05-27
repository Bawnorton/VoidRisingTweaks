package com.bawnorton.vrt.addons.entities.models;
// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import java.util.Random;

public class ModelCrawler extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer FrontRight;
	private final ModelRenderer ForeLeg1;
	private final ModelRenderer ForeLeg1_r1;
	private final ModelRenderer EndLeg1;
	private final ModelRenderer ForeLeg1_sub_1;
	private final ModelRenderer FrontLeft;
	private final ModelRenderer ForeLeg2;
	private final ModelRenderer ForeLeg2_r1;
	private final ModelRenderer EndLeg2;
	private final ModelRenderer ForeLeg2_sub_1;
	private final ModelRenderer BackLeft;
	private final ModelRenderer ForeLeg3;
	private final ModelRenderer ForeLeg3_r1;
	private final ModelRenderer EndLeg3;
	private final ModelRenderer ForeLeg3_sub_1;
	private final ModelRenderer BackRight;
	private final ModelRenderer ForeLeg4;
	private final ModelRenderer ForeLeg4_r1;
	private final ModelRenderer EndLeg4;
	private final ModelRenderer ForeLeg4_sub_1;

	public ModelCrawler() {
		textureWidth = 128;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 9.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -8.0F, -3.0F, -8.0F, 16, 8, 16, 0.0F, false));

		FrontRight = new ModelRenderer(this);
		FrontRight.setRotationPoint(7.0F, 9.0F, -5.0F);
		setRotationAngle(FrontRight, 0.0F, 0.4363F, 0.0F);
		

		ForeLeg1 = new ModelRenderer(this);
		ForeLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		FrontRight.addChild(ForeLeg1);
		setRotationAngle(ForeLeg1, 0.0F, -0.4363F, 0.0F);
		

		ForeLeg1_r1 = new ModelRenderer(this);
		ForeLeg1_r1.setRotationPoint(-1.0F, 0.0F, 0.001F);
		ForeLeg1.addChild(ForeLeg1_r1);
		setRotationAngle(ForeLeg1_r1, -0.2618F, 0.4363F, -0.5236F);
		ForeLeg1_r1.cubeList.add(new ModelBox(ForeLeg1_r1, 48, 0, 0.064F, -1.5059F, -1.6536F, 20, 4, 4, 0.0F, false));

		EndLeg1 = new ModelRenderer(this);
		EndLeg1.setRotationPoint(12.775F, -5.475F, -7.0F);
		ForeLeg1.addChild(EndLeg1);
		setRotationAngle(EndLeg1, -0.48F, 0.0873F, -1.3527F);
		

		ForeLeg1_sub_1 = new ModelRenderer(this);
		ForeLeg1_sub_1.setRotationPoint(1.4442F, 2.3837F, -0.073F);
		EndLeg1.addChild(ForeLeg1_sub_1);
		ForeLeg1_sub_1.cubeList.add(new ModelBox(ForeLeg1_sub_1, 0, 48, -5.4F, -3.4F, -1.998F, 6, 4, 4, 0.0F, true));
		ForeLeg1_sub_1.cubeList.add(new ModelBox(ForeLeg1_sub_1, 8, 29, -11.4F, -3.4F, -0.998F, 6, 3, 3, 0.0F, true));
		ForeLeg1_sub_1.cubeList.add(new ModelBox(ForeLeg1_sub_1, 10, 26, -17.4F, -3.4F, 0.002F, 6, 2, 2, 0.0F, true));
		ForeLeg1_sub_1.cubeList.add(new ModelBox(ForeLeg1_sub_1, 22, 44, -23.4F, -3.4F, 1.002F, 6, 1, 1, 0.0F, true));

		FrontLeft = new ModelRenderer(this);
		FrontLeft.setRotationPoint(-8.0F, 9.0F, -5.0F);
		setRotationAngle(FrontLeft, 0.0F, -0.4363F, 0.0F);
		

		ForeLeg2 = new ModelRenderer(this);
		ForeLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		FrontLeft.addChild(ForeLeg2);
		setRotationAngle(ForeLeg2, 0.0F, 0.4363F, 0.0F);
		

		ForeLeg2_r1 = new ModelRenderer(this);
		ForeLeg2_r1.setRotationPoint(1.0F, 0.0F, 0.001F);
		ForeLeg2.addChild(ForeLeg2_r1);
		setRotationAngle(ForeLeg2_r1, -0.2618F, -0.4363F, 0.5236F);
		ForeLeg2_r1.cubeList.add(new ModelBox(ForeLeg2_r1, 52, 28, -20.0F, -2.0F, -2.0F, 20, 4, 4, 0.0F, false));

		EndLeg2 = new ModelRenderer(this);
		EndLeg2.setRotationPoint(-13.5878F, -6.8859F, -8.375F);
		ForeLeg2.addChild(EndLeg2);
		setRotationAngle(EndLeg2, 0.4843F, 0.1309F, -1.7889F);
		

		ForeLeg2_sub_1 = new ModelRenderer(this);
		ForeLeg2_sub_1.setRotationPoint(0.8523F, 0.085F, 0.2316F);
		EndLeg2.addChild(ForeLeg2_sub_1);
		ForeLeg2_sub_1.cubeList.add(new ModelBox(ForeLeg2_sub_1, 0, 24, -6.0F, -1.75F, -1.75F, 6, 4, 4, 0.0F, true));
		ForeLeg2_sub_1.cubeList.add(new ModelBox(ForeLeg2_sub_1, 5, 26, -12.0F, -0.75F, -0.75F, 6, 3, 3, 0.0F, true));
		ForeLeg2_sub_1.cubeList.add(new ModelBox(ForeLeg2_sub_1, 29, 40, -18.0F, 0.25F, 0.25F, 6, 2, 2, 0.0F, true));
		ForeLeg2_sub_1.cubeList.add(new ModelBox(ForeLeg2_sub_1, 19, 30, -24.0F, 1.25F, 1.25F, 6, 1, 1, 0.0F, true));

		BackLeft = new ModelRenderer(this);
		BackLeft.setRotationPoint(-8.0F, 9.0F, 6.0F);
		setRotationAngle(BackLeft, 0.0F, 0.4363F, 0.0F);
		

		ForeLeg3 = new ModelRenderer(this);
		ForeLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackLeft.addChild(ForeLeg3);
		setRotationAngle(ForeLeg3, 0.0F, -0.4363F, 0.0F);
		

		ForeLeg3_r1 = new ModelRenderer(this);
		ForeLeg3_r1.setRotationPoint(1.0F, 0.0F, -0.001F);
		ForeLeg3.addChild(ForeLeg3_r1);
		setRotationAngle(ForeLeg3_r1, 0.2618F, 0.4363F, 0.5236F);
		ForeLeg3_r1.cubeList.add(new ModelBox(ForeLeg3_r1, 48, 8, -20.0F, -2.0F, -2.0F, 20, 4, 4, 0.0F, false));

		EndLeg3 = new ModelRenderer(this);
		EndLeg3.setRotationPoint(-13.45F, -7.2F, 7.875F);
		ForeLeg3.addChild(EndLeg3);
		setRotationAngle(EndLeg3, -0.4931F, -0.0873F, -1.7802F);
		

		ForeLeg3_sub_1 = new ModelRenderer(this);
		ForeLeg3_sub_1.setRotationPoint(-0.4865F, -0.3841F, 0.25F);
		EndLeg3.addChild(ForeLeg3_sub_1);
		ForeLeg3_sub_1.cubeList.add(new ModelBox(ForeLeg3_sub_1, 0, 32, -5.0F, -1.75F, -2.25F, 6, 4, 4, 0.0F, true));
		ForeLeg3_sub_1.cubeList.add(new ModelBox(ForeLeg3_sub_1, 3, 29, -11.0F, -0.75F, -2.25F, 6, 3, 3, 0.0F, true));
		ForeLeg3_sub_1.cubeList.add(new ModelBox(ForeLeg3_sub_1, 9, 32, -17.0F, 0.25F, -2.25F, 6, 2, 2, 0.0F, true));
		ForeLeg3_sub_1.cubeList.add(new ModelBox(ForeLeg3_sub_1, 20, 35, -23.0F, 1.25F, -2.25F, 6, 1, 1, 0.0F, true));

		BackRight = new ModelRenderer(this);
		BackRight.setRotationPoint(8.0F, 9.0F, 6.0F);
		setRotationAngle(BackRight, 0.0F, -0.4363F, 0.0F);
		

		ForeLeg4 = new ModelRenderer(this);
		ForeLeg4.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackRight.addChild(ForeLeg4);
		setRotationAngle(ForeLeg4, 0.0F, 0.4363F, 0.0F);
		

		ForeLeg4_r1 = new ModelRenderer(this);
		ForeLeg4_r1.setRotationPoint(-0.4641F, 0.4641F, 0.0F);
		ForeLeg4.addChild(ForeLeg4_r1);
		setRotationAngle(ForeLeg4_r1, 0.2618F, -0.4363F, -0.5236F);
		ForeLeg4_r1.cubeList.add(new ModelBox(ForeLeg4_r1, 52, 36, -0.5F, -2.55F, -2.026F, 20, 4, 4, 0.0F, false));

		EndLeg4 = new ModelRenderer(this);
		EndLeg4.setRotationPoint(14.05F, -6.95F, 7.8F);
		ForeLeg4.addChild(EndLeg4);
		setRotationAngle(EndLeg4, 0.48F, -0.0436F, -1.3963F);
		

		ForeLeg4_sub_1 = new ModelRenderer(this);
		ForeLeg4_sub_1.setRotationPoint(0.279F, -0.6131F, 0.0321F);
		EndLeg4.addChild(ForeLeg4_sub_1);
		ForeLeg4_sub_1.cubeList.add(new ModelBox(ForeLeg4_sub_1, 0, 40, -6.0F, -2.0F, -2.0F, 6, 4, 4, 0.0F, true));
		ForeLeg4_sub_1.cubeList.add(new ModelBox(ForeLeg4_sub_1, 6, 42, -12.0F, -2.0F, -2.0F, 6, 3, 3, 0.0F, true));
		ForeLeg4_sub_1.cubeList.add(new ModelBox(ForeLeg4_sub_1, 9, 44, -18.0F, -2.0F, -2.0F, 6, 2, 2, 0.0F, true));
		ForeLeg4_sub_1.cubeList.add(new ModelBox(ForeLeg4_sub_1, 23, 46, -24.0F, -2.0F, -2.0F, 6, 1, 1, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		FrontRight.render(f5);
		FrontLeft.render(f5);
		BackLeft.render(f5);
		BackRight.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.ForeLeg1.rotateAngleY = (float) Math.cos(limbSwing) * limbSwingAmount / -3F;
		this.ForeLeg2.rotateAngleY = (float) Math.cos(limbSwing) * limbSwingAmount / 3F;
		this.ForeLeg3.rotateAngleY = (float) Math.cos(limbSwing) * limbSwingAmount / -3F;
		this.ForeLeg4.rotateAngleY = (float) Math.cos(limbSwing) * limbSwingAmount / 3F;
		this.ForeLeg1.rotateAngleZ = (float) Math.cos(limbSwing) * limbSwingAmount / -4F;
		this.ForeLeg2.rotateAngleZ = (float) Math.cos(limbSwing) * limbSwingAmount / 4F;
		this.ForeLeg3.rotateAngleZ = (float) Math.cos(limbSwing) * limbSwingAmount / -4F;
		this.ForeLeg4.rotateAngleZ = (float) Math.cos(limbSwing) * limbSwingAmount / 4F;

		this.Body.rotateAngleX = (float) Math.cos(limbSwing) * limbSwingAmount / 6F;
		this.Body.rotateAngleX = (float) Math.cos(limbSwing) * limbSwingAmount / 8F;

		this.ForeLeg1_sub_1.rotateAngleZ = (float) Math.cos(limbSwing) * limbSwingAmount / 2F;
		this.ForeLeg2_sub_1.rotateAngleZ = (float) Math.cos(limbSwing) * limbSwingAmount / -2F;
		this.ForeLeg3_sub_1.rotateAngleZ = (float) Math.cos(limbSwing) * limbSwingAmount / 2F;
		this.ForeLeg4_sub_1.rotateAngleZ = (float) Math.cos(limbSwing) * limbSwingAmount / -2F;
	}
}