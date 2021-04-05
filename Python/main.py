import fileinput
import json
import glob
import shutil
import os


def save_file(path, settings):
    with open('/Users/benjamin/Documents/Developer/Minecraft/Modding/VoidRisingTweaks/src/main/resources/assets/vrt/'
              '{}.json'.format(path), 'w') as file:
        json.dump(settings, file, indent=4)


types = {
    'full': "Tainted ",
    'most': "Mostly Tainted ",
    'some': "Partially Tainted ",
    'few': "Slightly Tainted "
}
instance = {
    '_full': "TAINTED_",
    '_most': "MOSTLY_TAINTED_",
    '_some': "PARTIALLY_TAINTED_",
    '_few': "SLIGHTLY_TAINTED_"
}


def add_block(pre):
    for suffix in {"_full", "_most", "_some", "_few"}:
        name = pre + suffix
        blockstate = ({"variants": {"normal": {"model": "vrt:taint_{}".format(name)}}})
        block_model = ({"parent": "block/cube", "textures": {"all": "vrt:blocks/taint_{}".format(name)}})
        item_model = ({"parent": "vrt:block/taint_{}".format(name)})
        save_file("blockstates/taint_{}".format(name), blockstate)
        save_file("models/block/taint_{}".format(name), block_model)
        save_file("models/item/taint_{}".format(name), item_model)
        separated = name.split("_", -1)
        state = types[separated[len(separated) - 1]]
        block = name.split("_", 1)[0].capitalize()
        with open('/Users/benjamin/Documents/Developer/Minecraft/Modding/VoidRisingTweaks/src/main/resources/assets/vrt'
                  '/lang/en_us.lang', 'r') as file:
            data = file.readlines()
        data.append("\ntile.taint_{}.name=".format(name) + state + block)
        with open('/Users/benjamin/Documents/Developer/Minecraft/Modding/VoidRisingTweaks/src/main/resources/assets/vrt'
                  '/lang/en_us.lang', 'w') as file:
            file.writelines(data)
        for line in fileinput.FileInput(
                '/Users/benjamin/Documents/Developer/Minecraft/Modding/VoidRisingTweaks/src/main/java/com/bawnorton/vrt'
                '/addons/blocks/VRTBlockInit.java', inplace=1):
            if "//index" in line:
                line = line.replace(line, line + "    public static final Block " + instance[suffix] + block.upper() +
                                    " = new VRTTaintBlock(\"tainted_" + name + "\");\n")
            print(line, end='')
        for line in fileinput.FileInput(
                '/Users/benjamin/Documents/Developer/Minecraft/Modding/VoidRisingTweaks/src/main/java/com/bawnorton/vrt'
                '/addons/items/VRTItemInit.java', inplace=1):
            if "//index" in line:
                line = line.replace(line, line + "    public static final Item " + instance[suffix] + block.upper() +
                                    " = new ItemBlock(VRTBlockInit." + instance[suffix] + block.upper() + ");\n")
            print(line, end='')
    src_dir = "constpics"
    dst_dir = "pics"
    for jpgfile in glob.iglob(os.path.join(src_dir, "*.png")):
        shutil.copy(jpgfile, dst_dir)
    src_dir = "pics"
    dst_dir = "/Users/benjamin/Documents/Developer/Minecraft/Modding/VoidRisingTweaks/src/main/resources/assets/vrt" \
              "/textures/blocks/"
    for jpgfile in glob.iglob(os.path.join(src_dir, "*.png")):
        tgtfile = "pics/tainted_" + pre + "_" + str(jpgfile)[5:len(str(jpgfile))]
        os.rename(jpgfile, tgtfile)
        shutil.copy(tgtfile, dst_dir)
        os.remove(tgtfile)

add_block("ore_sapphire")
add_block("ore_ruby")
add_block("ore_redstone")
add_block("ore_lapis")
add_block("ore_emerald")
add_block("ore_diamond")
add_block("ore_coal")
add_block("ore_charged_certus")
add_block("ore_certus")
add_block("ore_uranium")
add_block("ore_tin")
add_block("ore_thorium")
add_block("ore_silver")
add_block("ore_magnesium")
add_block("ore_nickel")
add_block("ore_lithium")
add_block("ore_lead")
add_block("ore_iron")
add_block("ore_iridium")
add_block("ore_gold")
add_block("ore_galena")
add_block("ore_copper")
add_block("ore_boron")
add_block("ore_bauxite")
add_block("stone_bricks")
add_block("")
add_block("cobblestone")
