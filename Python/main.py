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

objects = []


def add_block(pre):
    global objects
    objects = []
    for suffix in {"_full", "_most", "_some", "_few"}:
        name = pre + suffix
        blockstate = ({"variants": {"normal": {"model": "vrt:tainted_{}".format(name)}}})
        block_model = ({"parent": "block/cube", "textures": {
            "north": "vrt:blocks/tainted_{}".format(name),
            "south": "vrt:blocks/tainted_{}".format(name),
            "east": "vrt:blocks/tainted_{}".format(name),
            "west": "vrt:blocks/tainted_{}".format(name),
            "up": "vrt:blocks/tainted_{}".format(name),
            "down": "vrt:blocks/tainted_{}".format(name),
            "particle": "vrt:blocks/tainted_{}".format(name)
        }})
        item_model = ({"parent": "vrt:block/tainted_{}".format(name)})
        save_file("blockstates/tainted_{}".format(name), blockstate)
        save_file("models/block/tainted_{}".format(name), block_model)
        save_file("models/item/tainted_{}".format(name), item_model)
        separated = name.split("_")
        state = types[separated[len(separated) - 1]]
        block = ""
        for entry in separated[0:len(separated) - 1]:
            block += entry + "_"
        block = block[0:len(block) - 1]
        objects.append(str(instance[suffix] + block.upper()))
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
    for line in fileinput.FileInput(
            '/Users/benjamin/Documents/Developer/Minecraft/Modding/VoidRisingTweaks/src/main/java/com/bawnorton/vrt'
            '/addons/blocks/VRTBlockInit.java', inplace=1):
        if "//table" in line:
            line = line.replace(line, line + "        put(\"tainted_" + pre + "\", new Block[]{" + objects[1] + ", " + objects[3] +
                                ", " + objects[2] + ", " + objects[0] + "});\n")
        print(line, end='')

add_block("stone")
add_block("dirt")